package com.kodingking.dislin.api.websocket.entities

import com.google.gson.annotations.SerializedName
import com.kodingking.dislin.entities.Snowflake
import com.kodingking.dislin.entities.enums.EnumStatusType
import com.kodingking.dislin.entities.impl.Activity
import com.kodingking.dislin.entities.raw.*

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
    @SerializedName("v") val version: Int,
    val user: UserRaw,
    @SerializedName("private_channels") val privateChannels: ArrayList<Any>,
    val guilds: ArrayList<GuildRaw>,
    @SerializedName("session_id") val sessionId: String,
    val shard: ArrayList<Int>?
) : WebSocketData()

data class ChannelPinsUpdateData(
    @SerializedName("guild_id") val guildId: Snowflake,
    @SerializedName("channel_id") val channelId: Snowflake,
    @SerializedName("last_pin_timestamp") val lastPinTimestamp: String?
) : WebSocketData()

data class GuildBanData(
    @SerializedName("guild_id") val guildId: Snowflake,
    val user: UserRaw
) : WebSocketData()

data class GuildEmojisUpdateData(
    @SerializedName("guild_id") val guildId: Snowflake,
    val emojis: ArrayList<EmojiRaw>
) : WebSocketData()

data class GuildIntegrationsUpdateData(
    @SerializedName("guild_id") val guildId: Snowflake
) : WebSocketData()

data class GuildMemberRemoveData(
    @SerializedName("guild_id") val guildId: Snowflake,
    val user: UserRaw
) : WebSocketData()

data class GuildMemberUpdateData(
    @SerializedName("guild_id") val guildId: Snowflake,
    val roles: ArrayList<Snowflake>,
    val user: UserRaw,
    val nick: String
) : WebSocketData()

data class GuildMembersChunkData(
    @SerializedName("guild_id") val guildId: Snowflake,
    val members: ArrayList<MemberRaw>
) : WebSocketData()

data class GuildRoleData(
    @SerializedName("guild_id") val guildId: Snowflake,
    val role: RoleRaw
) : WebSocketData()

data class GuildRoleDeleteData(
    @SerializedName("guild_id") val guildId: Snowflake,
    @SerializedName("role_id") val roleId: Snowflake
) : WebSocketData()

data class MessageDeleteData(
    val id: Snowflake,
    @SerializedName("channel_id") val channelId: Snowflake,
    @SerializedName("guild_id") val guildId: Snowflake?
) : WebSocketData()

data class MessageDeleteBulkData(
    val ids: ArrayList<Snowflake>,
    @SerializedName("channel_id") val channelId: Snowflake,
    @SerializedName("guild_id") val guildId: Snowflake?
) : WebSocketData()

data class MessageReactionData(
    @SerializedName("user_id") val userId: Snowflake,
    @SerializedName("channel_id") val channelId: Snowflake,
    @SerializedName("message_id") val messageId: Snowflake,
    @SerializedName("guild_id") val guildId: Snowflake?,
    val emoji: EmojiRaw
) : WebSocketData()

data class MessageReactionRemoveAllData(
    @SerializedName("channel_id") val channelId: Snowflake,
    @SerializedName("message_id") val messageId: Snowflake,
    @SerializedName("guild_id") val guildId: Snowflake?
) : WebSocketData()

data class TypingStartData(
    @SerializedName("channel_id") val channelId: Snowflake,
    @SerializedName("guild_id") val guildId: Snowflake?,
    @SerializedName("user_id") val userId: Snowflake,
    val timestamp: Int
) : WebSocketData()

data class VoiceServerUpdateData(
    val token: String,
    @SerializedName("guild_id") val guildId: Snowflake,
    val endpoint: String
) : WebSocketData()

data class WebhooksUpdateData(
    @SerializedName("guild_id") val guildId: Snowflake,
    @SerializedName("channel_id") val channelId: Snowflake
) : WebSocketData()

data class StatusUpdateData(
    var since: Int? = null,
    var game: Activity? = null,
    var status: EnumStatusType = EnumStatusType.ONLINE,
    var afk: Boolean = false
) : WebSocketData()