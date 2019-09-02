package com.kodingking.dislin.internal.gson.entities.enum

import com.google.gson.*
import com.kodingking.dislin.api.websocket.entities.EnumGatewayOpcode
import java.lang.reflect.Type

class EnumGatewayOpcodeJsonParser : JsonDeserializer<EnumGatewayOpcode>, JsonSerializer<EnumGatewayOpcode> {

    override fun serialize(src: EnumGatewayOpcode, typeOfSrc: Type, context: JsonSerializationContext) = JsonPrimitive(src.id)

    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ) = EnumGatewayOpcode.values[json.asInt]
}