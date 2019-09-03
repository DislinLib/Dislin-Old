package com.kodingking.dislin.entities.raw

import com.google.gson.annotations.SerializedName
import com.kodingking.dislin.entities.Snowflake

data class MemberRaw(
    @SerializedName("guild_id") val guildId: Snowflake?,
    val user: UserRaw,
    val nick: String?,
    val roles: ArrayList<Snowflake>,
    @SerializedName("joined_at") val joinedAt: String,
    @SerializedName("premium_since") val premiumSince: String?,
    val deaf: Boolean,
    val mute: Boolean
)