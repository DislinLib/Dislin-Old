package com.kodingking.dislin.api.rest.impl

import com.kodingking.dislin.DiscordData
import com.kodingking.dislin.Dislin
import com.kodingking.dislin.api.rest.core.BotRestAPI
import com.kodingking.dislin.api.rest.entities.GetGatewayBotResponse

class GatewayRest(dislin: Dislin) : BotRestAPI(dislin, dislin.token) {

    suspend fun getBotGateway() = httpGet<GetGatewayBotResponse>("${DiscordData.baseRestUrl}/gateway/bot")

}