package com.kodingking.dislin.entities.raw

import com.kodingking.dislin.entities.Snowflake

data class OverwriteRaw(
    val id: Snowflake,
    val type: String,
    val allow: Int,
    val deny: Int
)