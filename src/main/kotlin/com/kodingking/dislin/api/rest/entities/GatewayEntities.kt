package com.kodingking.dislin.api.rest.entities

import com.google.gson.annotations.SerializedName

data class GetGatewayBotResponse(
    val url: String,
    val shards: Int,
    @SerializedName("session_start_limit") val sessionStartLimit: SessionStartLimit
)

data class SessionStartLimit(
    val total: Int,
    val remaining: Int,
    @SerializedName("reset_after") val resetAfter: Int
)