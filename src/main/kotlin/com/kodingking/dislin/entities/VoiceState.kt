package com.kodingking.dislin.entities

import com.google.gson.annotations.SerializedName

data class VoiceState(
    @SerializedName("guild_id") val guildId: Snowflake?,
    @SerializedName("channel_id") val channelId: Snowflake,
    @SerializedName("user_id") val userId: Snowflake,
    val member: Member?,
    @SerializedName("session_id") val sessionId: String,
    val deaf: Boolean,
    val mute: Boolean,
    @SerializedName("self_deaf") val selfDeaf: Boolean,
    @SerializedName("self_mute") val selfMute: Boolean,
    val suppress: Boolean
)