package com.kodingking.dislin.entities.impl.channel

import com.kodingking.dislin.entities.Snowflake
import com.kodingking.dislin.entities.raw.EmbedRaw

data class SendableMessage(
    var content: String = "",
    var nonce: Snowflake? = null,
    var tts: Boolean = false,
    var embed: EmbedRaw? = null
)