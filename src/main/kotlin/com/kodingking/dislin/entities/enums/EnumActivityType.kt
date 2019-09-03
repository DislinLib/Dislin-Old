package com.kodingking.dislin.entities.enums

enum class EnumActivityType(val id: Int, val format: String) {

    GAME(0, "Playing %s"),
    STREAMING(1, "Streaming %s"),
    LISTENING(2, "Listening to %s");

    companion object {
        val values = values().map { it.id to it }.toMap()
    }

}