package com.kodingking.dislin

import com.google.gson.GsonBuilder
import com.kodingking.dislin.api.rest.RestController
import com.kodingking.dislin.api.websocket.core.CoreWebSocket
import com.kodingking.dislin.bot.EnumStatus
import com.kodingking.dislin.bot.handler.event.Event
import com.kodingking.dislin.bot.handler.event.ReactiveEventListener
import com.kodingking.dislin.bot.storage.SnowflakeCache
import com.kodingking.dislin.entities.Guild
import com.kodingking.dislin.entities.Role
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import java.io.File

class Dislin(val token: String, apply: Dislin.() -> Unit = {}) {

    private val coroutineScope = CoroutineScope(GlobalScope.coroutineContext)
    private val rest = RestController(this)

    val eventListener = ReactiveEventListener(this)

    val guildCache = SnowflakeCache<Guild>()
    val roleCache = SnowflakeCache<Role>()

    private lateinit var webSocket: CoreWebSocket

    private var status = EnumStatus.CONNECTING

    init {
        apply()

        Runtime.getRuntime().addShutdownHook(Thread {
            File("dump.json").writeText(GsonBuilder().setPrettyPrinting().create().toJson(this@Dislin.guildCache.data.filter { it.value.memberCount ?: 0 <= 100 }))
        })
    }

    suspend fun connect() {
        status = EnumStatus.CONNECTING

        val gateway = rest.gateway.getBotGateway()

        webSocket = CoreWebSocket(this, gateway.body.url)
        webSocket.connect()
    }

    suspend fun disconnect() {
        webSocket.stop()
        status = EnumStatus.DISCONNECTED
    }

    inline fun <reified T : Event> on() = eventListener.on<T>()

}