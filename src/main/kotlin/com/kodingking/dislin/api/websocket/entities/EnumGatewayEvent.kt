package com.kodingking.dislin.api.websocket.entities

import com.kodingking.dislin.api.websocket.core.EventHandler
import com.kodingking.dislin.bot.handler.gateway.GuildCreateEventHandler
import com.kodingking.dislin.bot.handler.gateway.MessageCreateEventHandler
import com.kodingking.dislin.entities.Guild
import com.kodingking.dislin.entities.Message

enum class EnumGatewayEvent(val eventHandler: EventHandler<out Any>? = null, val type: Class<out Any>? = null) {

    CHANNEL_CREATE,
    CHANNEL_UPDATE,
    CHANNEL_DELETE,
    CHANNEL_PINS_UPDATE,
    GUILD_CREATE(GuildCreateEventHandler(), Guild::class.java),
    GUILD_UPDATE,
    GUILD_DELETE,
    GUILD_BAN_ADD,
    GUILD_BAN_REMOVE,
    GUILD_EMOJIS_UPDATE,
    GUILD_INTEGRATIONS_UPDATE,
    GUILD_MEMBER_ADD,
    GUILD_MEMBER_REMOVE,
    GUILD_MEMBER_UPDATE,
    GUILD_MEMBERS_CHUNK,
    GUILD_ROLE_CREATE,
    GUILD_ROLE_UPDATE,
    GUILD_ROLE_DELETE,
    MESSAGE_CREATE(MessageCreateEventHandler(), Message::class.java),
    MESSAGE_UPDATE,
    MESSAGE_DELETE,
    MESSAGE_DELETE_BULK,
    MESSAGE_REACTION_ADD,
    MESSAGE_REACTION_REMOVE,
    MESSAGE_REACTION_REMOVE_ALL,
    PRESENCE_UPDATE,
    TYPING_START,
    USER_UPDATE,
    VOICE_STATE_UPDATE,
    VOICE_SERVER_UPDATE,
    WEBHOOKS_UPDATE;

    companion object {
        val values = values().map { it.name to it }.toMap()
    }

}