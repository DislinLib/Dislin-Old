package com.kodingking.dislin.entities.raw

import com.google.gson.annotations.SerializedName
import com.kodingking.dislin.entities.Snowflake

data class AttachmentRaw(
    val id: Snowflake,
    @SerializedName("filename") val fileName: String,
    val size: Int,
    val url: String,
    @SerializedName("proxy_url") val proxyUrl: String,
    val height: Int?,
    val width: Int?
)