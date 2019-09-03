package com.kodingking.dislin.entities.impl.channel

import com.kodingking.dislin.Dislin
import com.kodingking.dislin.api.rest.entities.ChannelInviteData
import com.kodingking.dislin.entities.impl.Channel
import com.kodingking.dislin.entities.impl.Guild
import com.kodingking.dislin.entities.raw.ChannelRaw

class MessageChannel(dislin: Dislin, guild: Guild, raw: ChannelRaw) : Channel(dislin, guild, raw) {

    var topic = raw.topic

    fun sendMessage(payload: SendableMessage) = dislin.rest.channel.createMessage(id, payload)
    fun createChannelInvite(payload: ChannelInviteData) = dislin.rest.channel.createChannelInvite(id, payload)

}