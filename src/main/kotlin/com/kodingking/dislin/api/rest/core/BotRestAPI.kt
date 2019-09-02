package com.kodingking.dislin.api.rest.core

import com.kodingking.dislin.Dislin
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.header

open class BotRestAPI(dislin: Dislin, private val token: String) : AbstractRestAPI(dislin) {

    override val baseApply: HttpRequestBuilder.() -> Unit = {
        header("Authorization", "Bot $token")
    }
}