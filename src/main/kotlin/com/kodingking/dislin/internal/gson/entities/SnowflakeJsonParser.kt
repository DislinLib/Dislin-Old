package com.kodingking.dislin.internal.gson.entities

import com.google.gson.*
import com.kodingking.dislin.entities.Snowflake
import java.lang.reflect.Type

class SnowflakeJsonParser : JsonDeserializer<Snowflake>, JsonSerializer<Snowflake> {

    override fun serialize(src: Snowflake, typeOfSrc: Type, context: JsonSerializationContext) = JsonPrimitive(src.raw)
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext) =
        Snowflake.parse(json.asString)
}