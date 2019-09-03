package com.kodingking.dislin.entities.enums

import com.google.gson.annotations.SerializedName

enum class EnumStatusType {

    @SerializedName("online")
    ONLINE,
    @SerializedName("dnd")
    DO_NOT_DISTURB,
    @SerializedName("idle")
    IDLE,
    @SerializedName("invisible")
    INVISIBLE,
    @SerializedName("offline")
    OFFLINE

}