package com.kodingking.dislin.entities

import com.google.gson.annotations.SerializedName

data class Embed(
    val title: String?,
    val type: String?,
    val description: String?,
    val url: String?,
    val timestamp: String?,
    val color: Int?,
    val footer: Footer?,
    val image: Image?,
    val thumbnail: Image?,
    val video: Video?,
    val provider: Provider?,
    val author: Author?,
    val fields: ArrayList<Field>?
) {
    data class Footer(
        val text: String,
        @SerializedName("icon_url") val iconUrl: String?,
        @SerializedName("proxy_icon_url") val proxyIconUrl: String?
    )

    data class Image(
        val url: String?,
        @SerializedName("proxy_url") val proxyUrl: String?,
        val height: Int?,
        val width: Int?
    )

    data class Video(
        val url: String?,
        val height: Int?,
        val width: Int?
    )

    data class Provider(
        val name: String?,
        val url: String?
    )

    data class Author(
        val name: String?,
        val url: String?,
        @SerializedName("icon_url") val iconUrl: String?,
        @SerializedName("proxy_icon_url") val proxyIconUrl: String?
    )

    data class Field(
        val name: String,
        val value: String,
        val inline: Boolean?
    )
}