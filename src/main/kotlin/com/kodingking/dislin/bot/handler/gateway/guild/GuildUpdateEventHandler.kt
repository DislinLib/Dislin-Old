package com.kodingking.dislin.bot.handler.gateway.guild

import com.kodingking.dislin.Dislin
import com.kodingking.dislin.api.websocket.core.CoreWebSocket
import com.kodingking.dislin.api.websocket.core.EventHandler
import com.kodingking.dislin.bot.handler.event.GuildIconUpdateEvent
import com.kodingking.dislin.entities.impl.Guild
import com.kodingking.dislin.entities.raw.GuildRaw

class GuildUpdateEventHandler : EventHandler<GuildRaw>() {

    override fun handle(dislin: Dislin, webSocket: CoreWebSocket, data: GuildRaw) {
        val newGuild = Guild(dislin, data)
        val oldGuild = dislin.guilds[data.id] ?: return

        if (newGuild.iconHash != oldGuild.iconHash) {
            oldGuild.iconHash = newGuild.iconHash
            dislin.eventListener.post(GuildIconUpdateEvent(dislin, oldGuild, oldGuild.iconUrl, newGuild.iconUrl))
        }
    }
}