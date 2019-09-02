package com.kodingking.dislin.api.websocket.dsl

import com.kodingking.dislin.api.websocket.entities.EnumGatewayOpcode
import com.kodingking.dislin.api.websocket.entities.GatewayMessage
import com.kodingking.dislin.api.websocket.entities.WebSocketData
import com.kodingking.dislin.gson

@DslMarker
annotation class GatewayMessageDSL

@GatewayMessageDSL
inline fun gatewayMessage(opcode: EnumGatewayOpcode = EnumGatewayOpcode.HELLO, build: GatewayMessage.() -> Unit = {}): GatewayMessage {
    val gatewayMessage = GatewayMessage(opcode)
    gatewayMessage.build()
    return gatewayMessage
}

@GatewayMessageDSL
fun GatewayMessage.data(data: Any) {
    this.data = gson.toJsonTree(data)
}

@GatewayMessageDSL
fun GatewayMessage.data(generate: () -> WebSocketData) = data(generate())