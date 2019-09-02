package com.kodingking.dislin.api.websocket.core

import com.kodingking.dislin.api.websocket.entities.GatewayMessage

abstract class MessageHandler {

    abstract suspend fun handle(webSocket: CoreWebSocket, message: GatewayMessage)

}