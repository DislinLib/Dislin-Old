package com.kodingking.dislin.api.websocket.core

import com.kodingking.dislin.Dislin

abstract class EventHandler<T> {

    abstract fun handle(dislin: Dislin, webSocket: CoreWebSocket, data: T)

}