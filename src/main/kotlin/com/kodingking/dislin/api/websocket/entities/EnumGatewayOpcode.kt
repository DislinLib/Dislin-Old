package com.kodingking.dislin.api.websocket.entities

import com.kodingking.dislin.api.websocket.core.MessageHandler
import com.kodingking.dislin.api.websocket.handler.message.DispatchMessageHandler
import com.kodingking.dislin.api.websocket.handler.message.HeartbeatMessageHandler
import com.kodingking.dislin.api.websocket.handler.message.HelloMessageHandler

enum class EnumGatewayOpcode(val id: Int, val messageHandler: MessageHandler? = null) {

    DISPATCH(0, DispatchMessageHandler()),
    HEARTBEAT(1, HeartbeatMessageHandler()),
    IDENTIFY(2),
    STATUS_UPDATE(3),
    VOICE_STATE_UPDATE(4),
    RESUME(6),
    RECONNECT(7),
    REQUEST_GUILD_MEMBERS(8),
    INVALID_SESSION(9),
    HELLO(10, HelloMessageHandler()),
    HEARTBEAT_ACK(11);

    companion object {
        val values = values().map { it.id to it }.toMap()
    }

}