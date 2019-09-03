package com.kodingking.dislin.api.rest.impl

import com.kodingking.dislin.DiscordData
import com.kodingking.dislin.Dislin
import com.kodingking.dislin.api.rest.core.BotRestAPI
import com.kodingking.dislin.api.rest.core.RateLimitedRestAPI
import com.kodingking.dislin.entities.Snowflake
import com.kodingking.dislin.entities.raw.UserRaw
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.reactor.flux

@UseExperimental(ExperimentalCoroutinesApi::class)
class UserRest(dislin: Dislin) : BotRestAPI(dislin, dislin.token), RateLimitedRestAPI {

    fun getUser(id: Snowflake) =
        flux {
            send(runRequest<UserRaw>(RateLimitedRestAPI.RateLimit(0, 0, 0L)) {
                httpGet("${DiscordData.baseRestUrl}/users/${id.raw}")
            }.body)
        }

}