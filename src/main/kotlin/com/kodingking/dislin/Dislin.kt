package com.kodingking.dislin

import com.kodingking.dislin.api.rest.RestController
import com.kodingking.dislin.api.websocket.core.CoreWebSocket
import com.kodingking.dislin.bot.EnumStatus
import com.kodingking.dislin.bot.handler.event.Event
import com.kodingking.dislin.bot.handler.event.ReactiveEventListener
import com.kodingking.dislin.bot.storage.SnowflakeCache
import com.kodingking.dislin.entities.impl.Guild
import com.kodingking.dislin.entities.impl.SelfUser

class Dislin(val token: String) {

    val rest = RestController(this)

    val eventListener = ReactiveEventListener(this)

    var selfUser: SelfUser? = null
    val guilds = SnowflakeCache<Guild>()

    lateinit var webSocket: CoreWebSocket

    private var status = EnumStatus.CONNECTING

    suspend fun connect() {
        status = EnumStatus.CONNECTING

        val gateway = rest.gateway.getBotGateway()

        webSocket = CoreWebSocket(this, gateway.body.url)
        webSocket.connect()
    }

    suspend fun disconnect() {
        webSocket.close()
        status = EnumStatus.DISCONNECTED
    }

    inline fun <reified T : Event> on() = eventListener.on<T>()

}