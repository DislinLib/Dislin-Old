package com.kodingking.dislin.api.websocket.handler.message

import com.kodingking.dislin.api.websocket.core.CoreWebSocket
import com.kodingking.dislin.api.websocket.core.MessageHandler
import com.kodingking.dislin.api.websocket.dsl.gatewayMessage
import com.kodingking.dislin.api.websocket.entities.EnumGatewayOpcode
import com.kodingking.dislin.api.websocket.entities.GatewayMessage

class HeartbeatMessageHandler : MessageHandler() {

    override suspend fun handle(webSocket: CoreWebSocket, message: GatewayMessage) {
        webSocket.send(gatewayMessage(EnumGatewayOpcode.HEARTBEAT_ACK))
    }
}