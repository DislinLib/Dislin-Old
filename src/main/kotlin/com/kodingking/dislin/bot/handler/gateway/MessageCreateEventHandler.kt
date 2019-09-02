package com.kodingking.dislin.bot.handler.gateway

import com.kodingking.dislin.Dislin
import com.kodingking.dislin.api.websocket.core.CoreWebSocket
import com.kodingking.dislin.api.websocket.core.EventHandler
import com.kodingking.dislin.bot.handler.event.MessageCreateEvent
import com.kodingking.dislin.entities.Message

class MessageCreateEventHandler : EventHandler<Message>() {

    override fun handle(dislin: Dislin, webSocket: CoreWebSocket, data: Message) {
        println(data.guild)
        data.guild?.messageCache?.set(data.id, data)
        dislin.eventListener.post(MessageCreateEvent(dislin, data))
    }
}