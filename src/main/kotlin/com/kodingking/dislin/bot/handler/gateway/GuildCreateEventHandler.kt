package com.kodingking.dislin.bot.handler.gateway

import com.kodingking.dislin.Dislin
import com.kodingking.dislin.api.websocket.core.CoreWebSocket
import com.kodingking.dislin.api.websocket.core.EventHandler
import com.kodingking.dislin.bot.handler.event.GuildCreateEvent
import com.kodingking.dislin.entities.Guild

class GuildCreateEventHandler : EventHandler<Guild>() {

    override fun handle(dislin: Dislin, webSocket: CoreWebSocket, data: Guild) {
        dislin.guildCache[data.id] = data
        dislin.eventListener.post(GuildCreateEvent(dislin, data))
    }
}