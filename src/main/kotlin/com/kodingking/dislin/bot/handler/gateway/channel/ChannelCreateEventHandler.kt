package com.kodingking.dislin.bot.handler.gateway.channel

import com.kodingking.dislin.Dislin
import com.kodingking.dislin.api.websocket.core.CoreWebSocket
import com.kodingking.dislin.api.websocket.core.EventHandler
import com.kodingking.dislin.bot.handler.event.ChannelCreateEvent
import com.kodingking.dislin.entities.Snowflake
import com.kodingking.dislin.entities.raw.ChannelRaw

class ChannelCreateEventHandler : EventHandler<ChannelRaw>() {

    override fun handle(dislin: Dislin, webSocket: CoreWebSocket, data: ChannelRaw) {
        val guild = dislin.guilds[data.guildId ?: Snowflake()] ?: return
        val channel = guild.registerChannel(data)
        dislin.eventListener.post(ChannelCreateEvent(dislin, channel))
    }
}