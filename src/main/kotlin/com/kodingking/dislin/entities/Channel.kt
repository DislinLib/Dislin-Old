package com.kodingking.dislin.entities

import com.google.gson.annotations.SerializedName

data class Channel(
    val id: Snowflake,
    val type: Int,
    @SerializedName("guild_id") val guildId: Snowflake?,
    val position: Int?,
    @SerializedName("permission_overwrites") val permissionOverwrites: ArrayList<Overwrite>,
    val name: String?,
    val topic: String?,
    val nsfw: Boolean?,
    @SerializedName("last_message_id") val lastMessageId: Snowflake,
    val bitrate: Int?,
    @SerializedName("user_limit") val userLimit: Int,
    @SerializedName("rate_limit_per_user") val rateLimitPerUser: Int,
    val recipients: ArrayList<User>,
    val icon: String?,
    @SerializedName("owner_id") val ownerId: Snowflake,
    @SerializedName("application_id") val applicationId: Snowflake,
    @SerializedName("parent_id") val parentId: String,
    @SerializedName("last_pin_timestamp") val lastPinTimestamp: String
)