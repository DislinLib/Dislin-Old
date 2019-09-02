package com.kodingking.dislin.api.websocket.entities

import com.google.gson.annotations.SerializedName
import com.kodingking.dislin.entities.*

open class WebSocketData

data class HeartbeatData(
    @SerializedName("heartbeat_interval") val heartbeatInterval: Long
) : WebSocketData()

data class IdentifyData(
    var token: String = "",
    var properties: IdentifyProperties = IdentifyProperties()
) : WebSocketData()

data class IdentifyProperties(
    @SerializedName("\$os") var os: String = "",
    @SerializedName("\$browser") var browser: String = "",
    @SerializedName("\$device") var device: String = ""
)

data class ReadyData(
    @SerializedName("v") private val version: Int,
    private val user: User,
    @SerializedName("private_chanels") private val privateChannels: ArrayList<Any>,
    private val guilds: ArrayList<Guild>,
    @SerializedName("session_id") private val sessionId: String,
    private val shard: ArrayList<Int>?
) : WebSocketData()

data class ChannelPinsUpdateData(
    @SerializedName("guild_id") private val guildId: Snowflake,
    @SerializedName("channel_id") private val channelId: Snowflake,
    @SerializedName("last_pin_timestamp") private val lastPinTimestamp: String?
) : WebSocketData()

data class GuildBanData(
    @SerializedName("guild_id") private val guildId: Snowflake,
    private val user: User
) : WebSocketData()

data class GuildEmojisUpdateData(
    @SerializedName("guild_id") private val guildId: Snowflake,
    private val emojis: ArrayList<Emoji>
) : WebSocketData()

data class GuildIntegrationsUpdateData(
    @SerializedName("guild_id") private val guildId: Snowflake
) : WebSocketData()

data class GuildMemberRemoveData(
    @SerializedName("guild_id") private val guildId: Snowflake,
    private val user: User
) : WebSocketData()

data class GuildMemberUpdateData(
    @SerializedName("guild_id") private val guildId: Snowflake,
    private val roles: ArrayList<Snowflake>,
    private val user: User,
    private val nick: String
) : WebSocketData()

data class GuildMembersChunkData(
    @SerializedName("guild_id") private val guildId: Snowflake,
    private val members: ArrayList<Member>
) : WebSocketData()

data class GuildRoleData(
    @SerializedName("guild_id") private val guildId: Snowflake,
    private val role: Role
) : WebSocketData()

data class GuildRoleDeleteData(
    @SerializedName("guild_id") private val guildId: Snowflake,
    @SerializedName("role_id") private val roleId: Snowflake
) : WebSocketData()

data class MessageDeleteData(
    private val id: Snowflake,
    @SerializedName("channel_id") private val channelId: Snowflake,
    @SerializedName("guild_id") private val guildId: Snowflake?
) : WebSocketData()

data class MessageDeleteBulkData(
    private val ids: ArrayList<Snowflake>,
    @SerializedName("channel_id") private val channelId: Snowflake,
    @SerializedName("guild_id") private val guildId: Snowflake?
) : WebSocketData()

data class MessageReactionData(
    @SerializedName("user_id") private val userId: Snowflake,
    @SerializedName("channel_id") private val channelId: Snowflake,
    @SerializedName("message_id") private val messageId: Snowflake,
    @SerializedName("guild_id") private val guildId: Snowflake?,
    private val emoji: Emoji
) : WebSocketData()

data class MessageReactionRemoveAllData(
    @SerializedName("channel_id") private val channelId: Snowflake,
    @SerializedName("message_id") private val messageId: Snowflake,
    @SerializedName("guild_id") private val guildId: Snowflake?
) : WebSocketData()

data class TypingStartData(
    @SerializedName("channel_id") private val channelId: Snowflake,
    @SerializedName("guild_id") private val guildId: Snowflake?,
    @SerializedName("user_id") private val userId: Snowflake,
    private val timestamp: Int
) : WebSocketData()

data class VoiceServerUpdateData(
    private val token: String,
    @SerializedName("guild_id") private val guildId: Snowflake,
    private val endpoint: String
) : WebSocketData()

data class WebhooksUpdateData(
    @SerializedName("guild_id") private val guildId: Snowflake,
    @SerializedName("channel_id") private val channelId: Snowflake
) : WebSocketData()