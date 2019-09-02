package com.kodingking.dislin.api.rest

import com.kodingking.dislin.Dislin
import com.kodingking.dislin.api.rest.impl.GatewayRest

class RestController(@Transient private val dislin: Dislin) {

    val gateway = GatewayRest(dislin)

}