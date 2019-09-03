package com.kodingking.dislin.api.rest.impl

import com.google.gson.JsonObject
import com.kodingking.dislin.DiscordData
import com.kodingking.dislin.Dislin
import com.kodingking.dislin.api.rest.core.BotRestAPI
import com.kodingking.dislin.api.rest.core.RateLimitedRestAPI
import com.kodingking.dislin.api.rest.entities.ChannelInviteData
import com.kodingking.dislin.entities.Snowflake
import com.kodingking.dislin.entities.impl.Channel
import com.kodingking.dislin.entities.impl.channel.SendableMessage
import com.kodingking.dislin.entities.raw.ChannelRaw
import com.kodingking.dislin.entities.raw.InviteRaw
import com.kodingking.dislin.entities.raw.MessageRaw
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.reactor.flux

@UseExperimental(ExperimentalCoroutinesApi::class)
class ChannelRest(dislin: Dislin) : BotRestAPI(dislin, dislin.token), RateLimitedRestAPI {

    fun getChannel(id: Snowflake) = flux {
        val raw = runRequest<ChannelRaw> {
            httpGet("${DiscordData.baseRestUrl}/channels/${id.raw}")
        }.body
        send(Channel(dislin, dislin.guilds[raw.guildId ?: Snowflake()] ?: return@flux, raw))
    }

    fun deleteChannel(id: Snowflake) = flux {
        val raw = runRequest<ChannelRaw> {
            httpDelete("${DiscordData.baseRestUrl}/channels/${id.raw}")
        }.body
        send(Channel(dislin, dislin.guilds[raw.guildId ?: Snowflake()] ?: return@flux, raw))
    }

    fun createMessage(channelId: Snowflake, message: SendableMessage) =
        flux {
            send(runRequest<MessageRaw> {
                httpPost("${DiscordData.baseRestUrl}/channels/${channelId.raw}/messages", content = message)
            }.body)
        }

    fun createChannelInvite(channelId: Snowflake, data: ChannelInviteData) =
        flux {
            send(runRequest<InviteRaw>(RateLimitedRestAPI.RateLimit(0, 0, 0L)) {
                httpPost(
                    "${DiscordData.baseRestUrl}/channels/${channelId.raw}/invites",
                    content = if (data == ChannelInviteData()) JsonObject() else data
                )
            }.body)
        }

}