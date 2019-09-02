package com.kodingking.dislin.api.websocket.handler.message

import com.kodingking.dislin.api.websocket.core.CoreWebSocket
import com.kodingking.dislin.api.websocket.core.EventHandler
import com.kodingking.dislin.api.websocket.core.MessageHandler
import com.kodingking.dislin.api.websocket.entities.EnumGatewayEvent
import com.kodingking.dislin.api.websocket.entities.GatewayMessage
import com.kodingking.dislin.internal.ext.toClass

class DispatchMessageHandler : MessageHandler() {

    @Suppress("UNCHECKED_CAST")
    override suspend fun handle(webSocket: CoreWebSocket, message: GatewayMessage) {
        webSocket.lastSequence = message.sequenceNumber

        val enum = EnumGatewayEvent.values[message.eventName] ?: return
        (enum.eventHandler as EventHandler<Any>?)?.handle(webSocket.dislin, webSocket, message.data!!.toClass(enum.type ?: return, webSocket.dislin))
    }
}