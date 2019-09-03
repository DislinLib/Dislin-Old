package com.kodingking.dislin

import com.kodingking.dislin.bot.handler.event.ReadyEvent
import com.kodingking.dislin.entities.dsl.activity
import com.kodingking.dislin.entities.enums.EnumActivityType
import com.kodingking.dislin.entities.enums.EnumStatusType

suspend fun main() {
    val token = System.getenv("token") ?: return
    val dislin = Dislin(token)

    dislin.on<ReadyEvent>()
        .subscribe {
            it.dislin.selfUser?.updatePresence(
                EnumStatusType.ONLINE,
                activity(dislin, "over many guilds", EnumActivityType.STREAMING)
            )?.subscribe()
        }

    dislin.connect()
}