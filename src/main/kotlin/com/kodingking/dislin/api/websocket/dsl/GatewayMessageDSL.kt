package com.kodingking.dislin.api.websocket.dsl

import com.kodingking.dislin.Dislin
import com.kodingking.dislin.DislinData
import com.kodingking.dislin.api.websocket.entities.EnumGatewayOpcode
import com.kodingking.dislin.api.websocket.entities.GatewayMessage
import com.kodingking.dislin.api.websocket.entities.WebSocketData

@DslMarker
annotation class GatewayMessageDSL

@GatewayMessageDSL
inline fun gatewayMessage(opcode: EnumGatewayOpcode = EnumGatewayOpcode.HELLO, build: GatewayMessage.() -> Unit = {}): GatewayMessage {
    val gatewayMessage = GatewayMessage(opcode)
    gatewayMessage.build()
    return gatewayMessage
}

@GatewayMessageDSL
fun GatewayMessage.data(dislin: Dislin, data: Any) {
    this.data = DislinData.getGson(dislin).toJsonTree(data)
}

@GatewayMessageDSL
fun GatewayMessage.data(dislin: Dislin, generate: () -> WebSocketData) = data(dislin, generate())