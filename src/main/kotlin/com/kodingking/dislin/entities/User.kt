package com.kodingking.dislin.entities

import com.google.gson.annotations.SerializedName

data class User(
    val id: Snowflake,
    val username: String,
    val discriminator: String,
    val avatar: String?,
    val bot: Boolean?,
    @SerializedName("mfa_enabled") val mfaEnabled: Boolean?,
    val locale: String,
    val flags: Int?,
    @SerializedName("premium_time") val premiumType: Int?
)