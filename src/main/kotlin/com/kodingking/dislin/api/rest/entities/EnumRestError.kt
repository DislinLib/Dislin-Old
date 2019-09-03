package com.kodingking.dislin.api.rest.entities

import com.kodingking.dislin.api.rest.core.DiscordNoPermissionsException

enum class EnumRestError(val code: Int, val exception: Exception) {

    MISSING_PERMISSIONS(50013, DiscordNoPermissionsException());

    companion object {
        val items = values().map { it.code to it }.toMap()
    }

}