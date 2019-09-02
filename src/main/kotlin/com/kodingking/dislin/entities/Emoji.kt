package com.kodingking.dislin.entities

import com.google.gson.annotations.SerializedName

data class Emoji(
    val id: Snowflake,
    val name: String,
    val roles: ArrayList<Snowflake>?,
    val user: User?,
    @SerializedName("require_colons") val requireColons: Boolean?,
    val managed: Boolean?,
    val animated: Boolean?
)