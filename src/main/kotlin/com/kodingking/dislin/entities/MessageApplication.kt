package com.kodingking.dislin.entities

import com.google.gson.annotations.SerializedName

data class MessageApplication(
    val id: Snowflake,
    @SerializedName("cover_image") val coverImage: String?,
    val description: String,
    val icon: String?,
    val name: String
)