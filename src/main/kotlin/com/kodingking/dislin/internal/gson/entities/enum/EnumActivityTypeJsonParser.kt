package com.kodingking.dislin.internal.gson.entities.enum

import com.google.gson.*
import com.kodingking.dislin.entities.enums.EnumActivityType
import java.lang.reflect.Type

class EnumActivityTypeJsonParser : JsonSerializer<EnumActivityType>, JsonDeserializer<EnumActivityType> {

    override fun serialize(src: EnumActivityType, typeOfSrc: Type, context: JsonSerializationContext) = JsonPrimitive(src.id)
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ) = EnumActivityType.values[json.asInt]
}