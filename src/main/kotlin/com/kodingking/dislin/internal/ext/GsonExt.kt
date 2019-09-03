package com.kodingking.dislin.internal.ext

import com.google.gson.GsonBuilder
import com.google.gson.JsonElement
import com.google.gson.reflect.TypeToken
import com.kodingking.dislin.Dislin
import com.kodingking.dislin.DislinData
import com.kodingking.dislin.api.websocket.entities.EnumGatewayOpcode
import com.kodingking.dislin.entities.Snowflake
import com.kodingking.dislin.entities.enums.EnumActivityType
import com.kodingking.dislin.internal.gson.entities.SnowflakeJsonParser
import com.kodingking.dislin.internal.gson.entities.enum.EnumActivityTypeJsonParser
import com.kodingking.dislin.internal.gson.entities.enum.EnumGatewayOpcodeJsonParser

fun GsonBuilder.components() {
    registerTypeAdapter(TypeToken.get(Snowflake::class.java).type, SnowflakeJsonParser())
    registerTypeAdapter(TypeToken.get(EnumGatewayOpcode::class.java).type, EnumGatewayOpcodeJsonParser())
    registerTypeAdapter(TypeToken.get(EnumActivityType::class.java).type, EnumActivityTypeJsonParser())
}

inline fun <reified T> JsonElement.to(dislin: Dislin): T = DislinData.getGson(dislin).fromJson(this, TypeToken.get(T::class.java).type)
fun <T> JsonElement.toClass(clazz: Class<T>, dislin: Dislin): T = DislinData.getGson(dislin).fromJson(this, TypeToken.get(clazz).type)