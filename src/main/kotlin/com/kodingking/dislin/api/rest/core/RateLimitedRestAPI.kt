package com.kodingking.dislin.api.rest.core

import kotlinx.coroutines.delay
import java.time.Instant
import java.time.format.DateTimeFormatter

interface RateLimitedRestAPI {

    suspend fun <T> runRequest(limit: RateLimit, execute: suspend () -> Response<T>): Response<T> {
        if (limit.remaining < 1)
            delay(limit.reset - System.currentTimeMillis() / 1000)

        with(execute()) {
            return try {
                checkStatus(this)
            } catch (e: DiscordRateLimitException) {
                val discordEpoch =
                    DateTimeFormatter.RFC_1123_DATE_TIME.parse(headers["Date"], Instant::from).epochSecond
                val discordDelta = discordEpoch - System.currentTimeMillis() / 1000

                limit.limit = headers["X-RateLimit-Limit"]?.toInt() ?: limit.limit
                limit.remaining = headers["X-RateLimit-Remaining"]?.toInt() ?: limit.remaining
                limit.reset = headers["X-RateLimit-Reset"]?.toLong()?.plus(discordDelta) ?: limit.reset

                runRequest(limit, execute)
            }
        }
    }

    private fun <T> checkStatus(response: Response<T>) = when (response.statusCode) {
        429 -> throw DiscordRateLimitException()
        else -> response
    }

    data class RateLimit(
        var limit: Int,
        var remaining: Int,
        var reset: Long
    )

}