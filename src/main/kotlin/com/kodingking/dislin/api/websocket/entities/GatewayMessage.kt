package com.kodingking.dislin.api.websocket.entities

import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName

data class GatewayMessage(
    @SerializedName("op") var opcode: EnumGatewayOpcode,
    @SerializedName("d") var data: JsonElement? = null,
    @SerializedName("s") var sequenceNumber: Int? = null,
    @SerializedName("t") var eventName: String? = null
)