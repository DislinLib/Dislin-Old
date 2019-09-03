package com.kodingking.dislin.entities.raw

import com.google.gson.annotations.SerializedName
import com.kodingking.dislin.entities.Snowflake
import com.kodingking.dislin.entities.enums.EnumActivityType

data class ActivityRaw(
    var name: String = "",
    var type: EnumActivityType = EnumActivityType.GAME,
    var url: String? = null,
    var timestamps: Timestamps? = null,
    @SerializedName("application_id") var applicationId: Snowflake? = null,
    var details: String? = null,
    var state: String? = null,
    var party: Party? = null,
    var assets: Assets? = null,
    var secrets: Secrets? = null,
    var instance: Boolean? = null,
    var flags: Int? = null
) {
    data class Timestamps(
        var start: Int? = null,
        var end: Int? = null
    )

    data class Party(
        var id: String? = null,
        var size: ArrayList<Int> = arrayListOf()
    )

    data class Assets(
        @SerializedName("large_image") var largeImage: String? = null,
        @SerializedName("large_text") var largeText: String? = null,
        @SerializedName("small_image") var smallImage: String? = null,
        @SerializedName("small_text") var smallText: String? = null
    )

    data class Secrets(
        var join: String? = null,
        var spectate: String? = null,
        var match: String? = null
    )
}