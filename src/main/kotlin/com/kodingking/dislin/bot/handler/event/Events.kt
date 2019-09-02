package com.kodingking.dislin.bot.handler.event

import com.kodingking.dislin.Dislin
import com.kodingking.dislin.entities.Guild
import com.kodingking.dislin.entities.Message

class GuildCreateEvent(dislin: Dislin, val guild: Guild) : Event(dislin)
class MessageCreateEvent(dislin: Dislin, val message: Message) : Event(dislin)