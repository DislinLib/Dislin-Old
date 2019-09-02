package com.kodingking.dislin.entities

data class Snowflake(
    val raw: String,
    val timestamp: Long,
    val internalWorkerId: Long,
    val internalProcessId: Long,
    val increment: Long
)