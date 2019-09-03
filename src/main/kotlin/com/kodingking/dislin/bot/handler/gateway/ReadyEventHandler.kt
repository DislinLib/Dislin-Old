package com.kodingking.dislin.bot.handler.gateway

import com.kodingking.dislin.Dislin
import com.kodingking.dislin.api.websocket.core.CoreWebSocket
import com.kodingking.dislin.api.websocket.core.EventHandler
import com.kodingking.dislin.api.websocket.entities.ReadyData
import com.kodingking.dislin.bot.handler.event.ReadyEvent
import com.kodingking.dislin.entities.impl.SelfUser

class ReadyEventHandler : EventHandler<ReadyData>() {

    override fun handle(dislin: Dislin, webSocket: CoreWebSocket, data: ReadyData) {
        dislin.selfUser = SelfUser(dislin, data.user)
        dislin.eventListener.post(ReadyEvent(dislin))
    }
}