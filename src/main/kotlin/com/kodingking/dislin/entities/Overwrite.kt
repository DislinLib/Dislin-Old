package com.kodingking.dislin.entities

data class Overwrite(
    val id: Snowflake,
    val type: String,
    val allow: Int,
    val deny: Int
)