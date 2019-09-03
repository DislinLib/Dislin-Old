package com.kodingking.dislin.api.websocket.core

import com.kodingking.dislin.DiscordData
import com.kodingking.dislin.Dislin
import com.kodingking.dislin.DislinData
import com.kodingking.dislin.api.websocket.entities.GatewayMessage
import io.ktor.client.HttpClient
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.websocket.WebSockets
import io.ktor.client.features.websocket.wss
import io.ktor.client.request.parameter
import io.ktor.http.cio.websocket.Frame
import io.ktor.http.cio.websocket.readText
import io.ktor.http.cio.websocket.send
import io.ktor.util.KtorExperimentalAPI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CoreWebSocket(@Transient val dislin: Dislin, private val url: String) {

    companion object {
        @UseExperimental(KtorExperimentalAPI::class)
        private val httpClient = HttpClient {
            install(WebSockets)
            install(JsonFeature) {
                serializer = GsonSerializer {
                    serializeNulls()
                }
            }
        }
    }

    val scope = CoroutineScope(GlobalScope.coroutineContext)

    private var send: (suspend (String) -> Unit)? = null
    private var close: (suspend (Throwable) -> Unit)? = null

    internal var lastSequence: Int? = null

    suspend fun connect() {
        httpClient.wss(url, request = {
            parameter("v", DiscordData.restVersion)
            parameter("encoding", "json")
        }) {
            send = this::send
            close = this::close

            scope.launch {
                val reason = this@wss.closeReason.await() ?: return@launch
                throw Exception("Websocket was closed (${reason.code}): ${reason.message}")
            }

            while (true) {
                val frame = try {
                    incoming.receive()
                } catch (e: Exception) {
                    e.printStackTrace()
                    break
                }

                val text = (frame as Frame.Text).readText()
                val message = DislinData.getGson(dislin).fromJson(text, GatewayMessage::class.java)
                message?.opcode?.messageHandler?.handle(this@CoreWebSocket, message)
            }
        }
    }

    suspend fun close() = close?.invoke(Exception("Closed"))
    suspend fun send(data: Any) = send?.invoke(DislinData.getGson(dislin).toJson(data))
    suspend fun send(build: () -> GatewayMessage) = send(build())

}