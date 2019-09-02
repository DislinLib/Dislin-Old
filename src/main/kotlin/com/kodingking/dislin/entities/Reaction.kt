package com.kodingking.dislin.entities

data class Reaction(
    val count: Int,
    val me: Boolean,
    val emoji: Emoji
)