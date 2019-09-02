package com.kodingking.dislin.entities

import com.google.gson.annotations.SerializedName

data class Presence(
    val user: User,
    val roles: ArrayList<Snowflake>,
    val game: Activity,
    @SerializedName("guild_id") val guildId: String,
    val status: String,
    val activities: ArrayList<Activity>,
    @SerializedName("client_status") val clientStatus: ClientStatus
)