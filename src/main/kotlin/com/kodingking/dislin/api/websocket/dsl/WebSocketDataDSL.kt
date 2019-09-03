package com.kodingking.dislin.api.websocket.dsl

import com.kodingking.dislin.api.websocket.entities.GatewayMessage
import com.kodingking.dislin.api.websocket.entities.IdentifyData
import com.kodingking.dislin.api.websocket.entities.IdentifyProperties
import com.kodingking.dislin.api.websocket.entities.StatusUpdateData

@DslMarker
annotation class WebSocketDataDSL

@WebSocketDataDSL
inline fun GatewayMessage.identify(build: IdentifyData.() -> Unit): IdentifyData {
    val identifyData = IdentifyData()
    identifyData.build()
    return identifyData
}

@WebSocketDataDSL
inline fun IdentifyData.properties(build: IdentifyProperties.() -> Unit) {
    val builder = IdentifyProperties()
    builder.build()
    properties = builder
}

@WebSocketDataDSL
inline fun GatewayMessage.statusUpdate(build: StatusUpdateData.() -> Unit): StatusUpdateData {
    val builder = StatusUpdateData()
    builder.build()
    return builder
}