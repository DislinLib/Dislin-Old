package com.kodingking.dislin.entities.raw

import com.kodingking.dislin.entities.Snowflake

data class RoleRaw(
    val id: Snowflake,
    val name: String,
    val color: Int,
    val hoist: Boolean,
    val position: Int,
    val permissions: Long,
    val managed: Boolean,
    val mentionable: Boolean
)