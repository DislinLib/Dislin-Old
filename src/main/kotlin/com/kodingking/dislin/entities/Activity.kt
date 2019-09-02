package com.kodingking.dislin.entities

import com.google.gson.annotations.SerializedName

data class Activity(
    val name: String,
    val type: Int,
    val url: String?,
    val timestamps: Timestamps,
    @SerializedName("application_id") val applicationId: Snowflake,
    val details: String?,
    val state: String?,
    val party: Party?,
    val assets: Assets?,
    val secrets: Secrets?,
    val instance: Boolean?,
    val flags: Int?
) {
    data class Timestamps(
        val start: Int?,
        val end: Int?
    )

    data class Party(
        val id: String?,
        val size: ArrayList<Int>
    )

    data class Assets(
        @SerializedName("large_image") val largeImage: String?,
        @SerializedName("large_text") val largeText: String?,
        @SerializedName("small_image") val smallImage: String?,
        @SerializedName("small_text") val smallText: String?
    )

    data class Secrets(
        val join: String?,
        val spectate: String?,
        val match: String?
    )
}