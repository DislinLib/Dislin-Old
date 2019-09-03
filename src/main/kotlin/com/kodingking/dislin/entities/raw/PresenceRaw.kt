package com.kodingking.dislin.entities.raw

import com.google.gson.annotations.SerializedName
import com.kodingking.dislin.entities.Snowflake

data class PresenceRaw(
    val user: UserRaw,
    val roles: ArrayList<Snowflake>,
    val game: ActivityRaw,
    @SerializedName("guild_id") val guildId: String,
    val status: String,
    val activities: ArrayList<ActivityRaw>,
    @SerializedName("client_status") val clientStatus: ClientStatusRaw
)