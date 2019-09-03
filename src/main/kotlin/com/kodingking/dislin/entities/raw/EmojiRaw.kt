package com.kodingking.dislin.entities.raw

import com.google.gson.annotations.SerializedName
import com.kodingking.dislin.entities.Snowflake

data class EmojiRaw(
    val id: Snowflake,
    val name: String,
    val roles: ArrayList<Snowflake>?,
    val user: UserRaw?,
    @SerializedName("require_colons") val requireColons: Boolean?,
    val managed: Boolean?,
    val animated: Boolean?
)