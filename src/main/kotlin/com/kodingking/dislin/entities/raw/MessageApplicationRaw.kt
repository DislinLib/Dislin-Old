package com.kodingking.dislin.entities.raw

import com.google.gson.annotations.SerializedName
import com.kodingking.dislin.entities.Snowflake

data class MessageApplicationRaw(
    val id: Snowflake,
    @SerializedName("cover_image") val coverImage: String?,
    val description: String,
    val icon: String?,
    val name: String
)