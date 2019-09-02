package com.kodingking.dislin.internal.gson.entities

import com.google.gson.*
import com.kodingking.dislin.entities.Snowflake
import java.lang.reflect.Type

class SnowflakeJsonParser : JsonDeserializer<Snowflake>, JsonSerializer<Snowflake> {

    override fun serialize(src: Snowflake, typeOfSrc: Type, context: JsonSerializationContext) = JsonPrimitive(src.raw)

    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext) =
        with(json.asString.toLong()) {
            Snowflake(
                json.asString, (this shr 22) + 1420070400000, this and 0x3E0000 shr 17,
                this and 0x1F000 shr 12, this and 0xFFF
            )
        }
}