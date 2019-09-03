package com.kodingking.dislin.api.rest.entities

import com.google.gson.annotations.SerializedName

data class ChannelInviteData(
    @SerializedName("max_age") var maxAge: Int = 86400,
    @SerializedName("max_uses") var maxUses: Int = 0,
    var temporary: Boolean = false,
    var unique: Boolean = false
)