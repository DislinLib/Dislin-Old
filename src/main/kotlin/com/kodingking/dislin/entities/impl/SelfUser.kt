package com.kodingking.dislin.entities.impl

import com.kodingking.dislin.Dislin
import com.kodingking.dislin.api.websocket.dsl.data
import com.kodingking.dislin.api.websocket.dsl.gatewayMessage
import com.kodingking.dislin.api.websocket.dsl.statusUpdate
import com.kodingking.dislin.api.websocket.entities.EnumGatewayOpcode
import com.kodingking.dislin.entities.enums.EnumStatusType
import com.kodingking.dislin.entities.raw.UserRaw
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.reactor.flux

@UseExperimental(ExperimentalCoroutinesApi::class)
class SelfUser(dislin: Dislin, raw: UserRaw) : User(dislin, raw) {

    fun updatePresence(status: EnumStatusType = EnumStatusType.ONLINE, activity: Activity? = null) = flux<Unit?> {
        dislin.webSocket.send {
            gatewayMessage(EnumGatewayOpcode.STATUS_UPDATE) {
                data(dislin) {
                    statusUpdate {
                        this.status = status
                        game = activity
                    }
                }
            }
        }
    }

}