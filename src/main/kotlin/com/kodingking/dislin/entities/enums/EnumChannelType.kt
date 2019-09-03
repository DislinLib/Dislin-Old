package com.kodingking.dislin.entities.enums

import com.google.gson.annotations.SerializedName

enum class EnumChannelType {

    @SerializedName("0")
    GUILD_TEXT,
    @SerializedName("1")
    DM,
    @SerializedName("2")
    GUILD_VOICE,
    @SerializedName("3")
    GROUP_DM,
    @SerializedName("4")
    GUILD_CATEGORY,
    @SerializedName("5")
    GUILD_NEWS,
    @SerializedName("6")
    GUILD_STORE

}