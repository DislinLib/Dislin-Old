package com.kodingking.dislin.entities

import com.google.gson.annotations.SerializedName

data class MessageReference(
    @SerializedName("message_id") val messageId: Snowflake?,
    @SerializedName("channel_id") val channelId: Snowflake,
    @SerializedName("guild_id") val guildId: Snowflake?
)