package com.kodingking.dislin.entities

data class Snowflake(
    val raw: String = "",
    val timestamp: Long = 0L,
    val internalWorkerId: Long = 0L,
    val internalProcessId: Long = 0L,
    val increment: Long = 0L
) {
    companion object {
        fun parse(snowflake: String) = with(snowflake.toLong()) {
            Snowflake(
                snowflake, (this shr 22) + 1420070400000, this and 0x3E0000 shr 17,
                this and 0x1F000 shr 12, this and 0xFFF
            )
        }
    }
}