package com.kodingking.dislin.api.websocket.entities

import com.kodingking.dislin.api.websocket.core.EventHandler
import com.kodingking.dislin.bot.handler.gateway.*
import com.kodingking.dislin.bot.handler.gateway.channel.ChannelCreateEventHandler
import com.kodingking.dislin.bot.handler.gateway.channel.ChannelDeleteEventHandler
import com.kodingking.dislin.bot.handler.gateway.guild.GuildCreateEventHandler
import com.kodingking.dislin.bot.handler.gateway.guild.GuildUpdateEventHandler
import com.kodingking.dislin.bot.handler.gateway.message.MessageCreateEventHandler
import com.kodingking.dislin.bot.handler.gateway.message.MessageDeleteEventHandler
import com.kodingking.dislin.entities.raw.ChannelRaw
import com.kodingking.dislin.entities.raw.GuildRaw
import com.kodingking.dislin.entities.raw.MessageRaw

enum class EnumGatewayEvent(val eventHandler: EventHandler<out Any>? = null, val type: Class<out Any>? = null) {

    READY(ReadyEventHandler(), ReadyData::class.java),
    CHANNEL_CREATE(ChannelCreateEventHandler(), ChannelRaw::class.java),
    CHANNEL_UPDATE,
    CHANNEL_DELETE(ChannelDeleteEventHandler(), ChannelRaw::class.java),
    CHANNEL_PINS_UPDATE,
    GUILD_CREATE(GuildCreateEventHandler(), GuildRaw::class.java),
    GUILD_UPDATE(GuildUpdateEventHandler(), GuildRaw::class.java),
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
    MESSAGE_CREATE(MessageCreateEventHandler(), MessageRaw::class.java),
    MESSAGE_UPDATE,
    MESSAGE_DELETE(MessageDeleteEventHandler(), MessageDeleteData::class.java),
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