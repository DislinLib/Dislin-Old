package com.kodingking.dislin.entities.raw

import com.google.gson.annotations.SerializedName
import com.kodingking.dislin.entities.Snowflake

data class VoiceStateRaw(
    @SerializedName("guild_id") val guildId: Snowflake?,
    @SerializedName("channel_id") val channelId: Snowflake,
    @SerializedName("user_id") val userId: Snowflake,
    val member: MemberRaw?,
    @SerializedName("session_id") val sessionId: String,
    val deaf: Boolean,
    val mute: Boolean,
    @SerializedName("self_deaf") val selfDeaf: Boolean,
    @SerializedName("self_mute") val selfMute: Boolean,
    val suppress: Boolean
)