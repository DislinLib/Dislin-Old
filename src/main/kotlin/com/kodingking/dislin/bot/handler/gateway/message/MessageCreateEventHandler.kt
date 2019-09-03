package com.kodingking.dislin.bot.handler.gateway.message

import com.kodingking.dislin.Dislin
import com.kodingking.dislin.api.websocket.core.CoreWebSocket
import com.kodingking.dislin.api.websocket.core.EventHandler
import com.kodingking.dislin.bot.handler.event.MessageCreateEvent
import com.kodingking.dislin.entities.Snowflake
import com.kodingking.dislin.entities.impl.Message
import com.kodingking.dislin.entities.raw.MessageRaw

class MessageCreateEventHandler : EventHandler<MessageRaw>() {

    override fun handle(dislin: Dislin, webSocket: CoreWebSocket, data: MessageRaw) {
        val guild = dislin.guilds[data.guildId ?: Snowflake()] ?: return
        val message = Message(dislin, guild, data)
        guild.messages[data.id] = message
        dislin.eventListener.post(MessageCreateEvent(dislin, message))
    }
}