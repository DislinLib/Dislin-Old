package com.kodingking.dislin.bot.handler.gateway.guild

import com.kodingking.dislin.Dislin
import com.kodingking.dislin.api.websocket.core.CoreWebSocket
import com.kodingking.dislin.api.websocket.core.EventHandler
import com.kodingking.dislin.bot.handler.event.GuildCreateEvent
import com.kodingking.dislin.entities.impl.Guild
import com.kodingking.dislin.entities.raw.GuildRaw

class GuildCreateEventHandler : EventHandler<GuildRaw>() {

    override fun handle(dislin: Dislin, webSocket: CoreWebSocket, data: GuildRaw) {
        val guild = Guild(dislin, data)
        dislin.guilds[data.id] = guild
        dislin.eventListener.post(GuildCreateEvent(dislin, guild))
    }
}