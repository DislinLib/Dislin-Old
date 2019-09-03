package com.kodingking.dislin.bot.handler.gateway.message

import com.kodingking.dislin.Dislin
import com.kodingking.dislin.api.websocket.core.CoreWebSocket
import com.kodingking.dislin.api.websocket.core.EventHandler
import com.kodingking.dislin.api.websocket.entities.MessageDeleteData
import com.kodingking.dislin.bot.handler.event.MessageDeleteEvent

class MessageDeleteEventHandler : EventHandler<MessageDeleteData>() {

    override fun handle(dislin: Dislin, webSocket: CoreWebSocket, data: MessageDeleteData) {
        val guild = dislin.guilds[data.guildId ?: return] ?: return
        val message = guild.messages.remove(data.id) ?: return
        dislin.eventListener.post(MessageDeleteEvent(dislin, guild, message))
    }
}