package com.kodingking.dislin.entities.impl

import com.kodingking.dislin.Dislin
import com.kodingking.dislin.entities.Snowflake
import com.kodingking.dislin.entities.impl.channel.MessageChannel
import com.kodingking.dislin.entities.raw.MessageRaw

class Message(@Transient val dislin: Dislin, @Transient val guild: Guild, raw: MessageRaw) {

    private val authorId = raw.author?.id
    private val channelId = raw.channelId

    val id = raw.id

    val author: User?
        get() = guild.members[authorId ?: Snowflake()]?.user
    val channel: MessageChannel?
        get() = guild.channels[channelId] as MessageChannel?

    var content = raw.content

}