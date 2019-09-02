package com.kodingking.dislin.entities

import com.google.gson.annotations.SerializedName

data class Attachment(
    val id: Snowflake,
    @SerializedName("filename") val fileName: String,
    val size: Int,
    val url: String,
    @SerializedName("proxy_url") val proxyUrl: String,
    val height: Int?,
    val width: Int?
)