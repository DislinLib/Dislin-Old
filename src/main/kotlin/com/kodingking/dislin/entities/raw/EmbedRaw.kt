package com.kodingking.dislin.entities.raw

import com.google.gson.annotations.SerializedName

data class EmbedRaw(
    var title: String? = null,
    var type: String? = null,
    var description: String? = null,
    var url: String? = null,
    var timestamp: String? = null,
    var color: Int? = null,
    var footer: Footer? = null,
    var image: Image? = null,
    var thumbnail: Image? = null,
    private val video: Video? = null,
    private val provider: Provider? = null,
    var author: Author? = null,
    var fields: ArrayList<Field> = arrayListOf()
) {
    data class Footer(
        var text: String = "",
        @SerializedName("icon_url") var iconUrl: String? = null,
        @SerializedName("proxy_icon_url") private val proxyIconUrl: String? = null
    )

    data class Image(
        var url: String? = null,
        @SerializedName("proxy_url") private val proxyUrl: String? = null,
        private val height: Int? = null,
        private val width: Int? = null
    )

    data class Video(
        var url: String?,
        var height: Int?,
        var width: Int?
    )

    data class Provider(
        var name: String? = null,
        var url: String? = null
    )

    data class Author(
        var name: String? = null,
        var url: String? = null,
        @SerializedName("icon_url") var iconUrl: String? = null,
        @SerializedName("proxy_icon_url") private val proxyIconUrl: String? = null
    )

    data class Field(
        var name: String,
        var value: String,
        var inline: Boolean? = false
    )
}