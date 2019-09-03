package com.kodingking.dislin.entities.impl

import com.kodingking.dislin.Dislin
import com.kodingking.dislin.entities.raw.ChannelRaw

open class Channel(@Transient val dislin: Dislin, @Transient val guild: Guild, raw: ChannelRaw) {

    val id = raw.id
    val type = raw.type

    var name = raw.name

    fun delete() = dislin.rest.channel.deleteChannel(id)

}