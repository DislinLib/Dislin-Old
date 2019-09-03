package com.kodingking.dislin.entities.raw

import com.google.gson.annotations.SerializedName
import com.kodingking.dislin.entities.Snowflake

data class UserRaw(
    val id: Snowflake,
    val username: String,
    val discriminator: String,
    val avatar: String?,
    val bot: Boolean?,
    @SerializedName("mfa_enabled") val mfaEnabled: Boolean?,
    val locale: String
//    val flags: Int?,
//    @SerializedName("premium_type") val premiumType: EnumPremiumType?
)