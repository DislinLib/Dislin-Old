package com.kodingking.dislin.api.rest

import com.kodingking.dislin.Dislin
import com.kodingking.dislin.api.rest.impl.ChannelRest
import com.kodingking.dislin.api.rest.impl.GatewayRest
import com.kodingking.dislin.api.rest.impl.UserRest

class RestController(@Transient private val dislin: Dislin) {

    val gateway = GatewayRest(dislin)
    val channel = ChannelRest(dislin)
    val user = UserRest(dislin)

}