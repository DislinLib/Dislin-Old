package com.kodingking.dislin.entities.dsl

import com.kodingking.dislin.entities.impl.channel.MessageChannel
import com.kodingking.dislin.entities.impl.channel.SendableMessage
import com.kodingking.dislin.entities.raw.EmbedRaw

annotation class MessageChannelDSL

@MessageChannelDSL
suspend fun MessageChannel.send(build: SendableMessage.() -> Unit) {
    val message = SendableMessage()
    message.build()
    sendMessage(message)
}

@MessageChannelDSL
fun SendableMessage.embed(build: EmbedRaw.() -> Unit) {
    val raw = EmbedRaw()
    raw.build()
    embed = raw
}

@MessageChannelDSL
fun EmbedRaw.field(build: EmbedRaw.Field.() -> Unit) {
    val field = EmbedRaw.Field("", "")
    field.build()
    fields.add(field)
}

@MessageChannelDSL
fun EmbedRaw.footer(build: EmbedRaw.Footer.() -> Unit) {
    val builder = EmbedRaw.Footer()
    builder.build()
    footer = builder
}