package com.kodingking.dislin.api.rest.core

import com.kodingking.dislin.Dislin
import com.kodingking.dislin.DislinData
import com.kodingking.dislin.api.rest.entities.EnumRestError
import io.ktor.client.response.HttpResponse
import io.ktor.http.Headers
import kotlinx.coroutines.io.jvm.javaio.toInputStream

data class Response<T>(
    val body: T,
    val statusCode: Int,
    val headers: Headers
)

data class ErrorResponse(
    val code: Int,
    val message: String
)

inline fun <reified T> HttpResponse.asResponse(dislin: Dislin): Response<T> {
    val statusCode = status.value
    val text = content.toInputStream().bufferedReader().readText()
    val gson = DislinData.getGson(dislin)

    return try {
        checkStatus(statusCode)
        Response(gson.fromJson(text, T::class.java), statusCode, headers)
    } catch (e: Exception) {
        val parsed = gson.fromJson(text, ErrorResponse::class.java)
        throw EnumRestError.items[parsed.code]?.exception ?: e
    }
}