package com.kodingking.dislin.entities.raw

import com.google.gson.annotations.SerializedName
import com.kodingking.dislin.entities.Snowflake

data class MessageReferenceRaw(
    @SerializedName("message_id") val messageId: Snowflake?,
    @SerializedName("channel_id") val channelId: Snowflake,
    @SerializedName("guild_id") val guildId: Snowflake?
)