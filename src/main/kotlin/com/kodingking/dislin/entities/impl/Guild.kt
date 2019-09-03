package com.kodingking.dislin.entities.impl

import com.kodingking.dislin.Dislin
import com.kodingking.dislin.bot.storage.SnowflakeCache
import com.kodingking.dislin.entities.enums.EnumChannelType
import com.kodingking.dislin.entities.impl.channel.MessageChannel
import com.kodingking.dislin.entities.raw.ChannelRaw
import com.kodingking.dislin.entities.raw.GuildRaw

class Guild(@Transient val dislin: Dislin, raw: GuildRaw) {

    val id = raw.id

    var isOwner = raw.owner
    var name = raw.name
    var ownerId = raw.ownerId

    val owner: Member?
        get() = members[ownerId]

    var iconHash = raw.icon

    val iconUrl: String
        get() = "https://cdn.discordapp.com/icons/$id/$iconHash"

    val members = SnowflakeCache<Member>()
    val messages = SnowflakeCache<Message>()
    val channels = SnowflakeCache<Channel>()
    val roles = SnowflakeCache<Role>()

    init {
        raw.roles.forEach { roles[it.id] = Role(dislin, this, it) }
        raw.members.forEach { members[it.user.id] = Member(dislin, this, it) }
        raw.channels.forEach { registerChannel(it) }
    }

    internal fun registerChannel(raw: ChannelRaw): Channel {
        val channel = when (raw.type) {
            EnumChannelType.GUILD_TEXT -> MessageChannel(dislin, this, raw)
            else -> Channel(dislin, this, raw)
        }
        channels[raw.id] = channel
        return channel
    }

}