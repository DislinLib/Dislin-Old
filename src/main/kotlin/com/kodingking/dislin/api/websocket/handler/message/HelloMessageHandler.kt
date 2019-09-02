package com.kodingking.dislin.api.websocket.handler.message

import com.google.gson.JsonPrimitive
import com.kodingking.dislin.api.websocket.core.CoreWebSocket
import com.kodingking.dislin.api.websocket.core.MessageHandler
import com.kodingking.dislin.api.websocket.dsl.data
import com.kodingking.dislin.api.websocket.dsl.gatewayMessage
import com.kodingking.dislin.api.websocket.dsl.identify
import com.kodingking.dislin.api.websocket.dsl.properties
import com.kodingking.dislin.api.websocket.entities.EnumGatewayOpcode
import com.kodingking.dislin.api.websocket.entities.GatewayMessage
import com.kodingking.dislin.api.websocket.entities.HeartbeatData
import com.kodingking.dislin.internal.ext.to
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class HelloMessageHandler : MessageHandler() {

    override suspend fun handle(webSocket: CoreWebSocket, message: GatewayMessage) {
        val heartbeatData = message.data!!.to<HeartbeatData>(webSocket.dislin)

        webSocket.scope.launch {
            while (isActive) {
                delay(heartbeatData.heartbeatInterval)

                webSocket.send(
                    gatewayMessage(EnumGatewayOpcode.HEARTBEAT) {
                        data = if (sequenceNumber == null) null else JsonPrimitive(sequenceNumber)
                    }
                )
            }
        }

        webSocket.send(
            gatewayMessage(EnumGatewayOpcode.IDENTIFY) {
                data {
                    identify {
                        token = webSocket.dislin.token

                        properties {
                            os = System.getProperty("os.name")
                            browser = "Dislin"
                            device = "Dislin"
                        }
                    }
                }
            }
        )
    }
}