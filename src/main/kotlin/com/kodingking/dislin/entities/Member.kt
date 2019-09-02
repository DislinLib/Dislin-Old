package com.kodingking.dislin.entities

import com.google.gson.annotations.SerializedName
import com.kodingking.dislin.Dislin

class Member(
    dislin: Dislin,
    @SerializedName("guild_id") val guildId: Snowflake,
    val user: User,
    val nick: String?,
    val roles: ArrayList<Role>,
    @SerializedName("joined_at") val joinedAt: String,
    @SerializedName("premium_since") val premiumSince: String?,
    val deaf: Boolean,
    val mute: Boolean
) : DislinEntity(dislin) {
    val guild: Guild?
        get() {
            return dislin.guildCache[guildId]
        }
}