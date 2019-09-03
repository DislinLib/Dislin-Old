package com.kodingking.dislin.bot.handler.event

import com.kodingking.dislin.Dislin
import com.kodingking.dislin.entities.impl.Channel
import com.kodingking.dislin.entities.impl.Guild
import com.kodingking.dislin.entities.impl.Message

class ReadyEvent(dislin: Dislin) : Event(dislin)

class ChannelCreateEvent(dislin: Dislin, val channel: Channel) : Event(dislin)
class ChannelDeleteEvent(dislin: Dislin, val channel: Channel) : Event(dislin)

class GuildCreateEvent(dislin: Dislin, val guild: Guild) : Event(dislin)
class GuildIconUpdateEvent(dislin: Dislin, @Transient val guild: Guild, val oldUrl: String, val newUrl: String) : Event(dislin)

class MessageCreateEvent(dislin: Dislin, val message: Message) : Event(dislin)
class MessageDeleteEvent(dislin: Dislin, @Transient val guild: Guild, val message: Message) : Event(dislin)