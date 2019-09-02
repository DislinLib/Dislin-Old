package com.kodingking.dislin.internal.ext

import com.google.gson.GsonBuilder
import com.google.gson.JsonElement
import com.google.gson.reflect.TypeToken
import com.kodingking.dislin.Dislin
import com.kodingking.dislin.DislinData
import com.kodingking.dislin.api.websocket.entities.EnumGatewayOpcode
import com.kodingking.dislin.bot.storage.SnowflakeCache
import com.kodingking.dislin.entities.Member
import com.kodingking.dislin.entities.Role
import com.kodingking.dislin.entities.Snowflake
import com.kodingking.dislin.internal.gson.entities.DislinEntityTypeAdapterFactory
import com.kodingking.dislin.internal.gson.entities.SnowflakeJsonParser
import com.kodingking.dislin.internal.gson.entities.enum.EnumGatewayOpcodeJsonParser
import com.kodingking.dislin.internal.gson.entities.mapping.MapSnowflakeToRoleJsonParser
import com.kodingking.dislin.internal.gson.entities.storage.MemberSnowflakeCacheJsonParser
import com.kodingking.dislin.internal.gson.entities.storage.RoleSnowflakeCacheJsonParser

fun GsonBuilder.components(dislin: Dislin? = null) {
    registerTypeAdapter(TypeToken.get(Snowflake::class.java).type, SnowflakeJsonParser())
    registerTypeAdapter(TypeToken.get(EnumGatewayOpcode::class.java).type, EnumGatewayOpcodeJsonParser())

    registerTypeAdapter(object : TypeToken<SnowflakeCache<Member>>() {}.type, MemberSnowflakeCacheJsonParser(dislin ?: return))
    registerTypeAdapter(object : TypeToken<SnowflakeCache<Role>>() {}.type, RoleSnowflakeCacheJsonParser(dislin))
    registerTypeAdapter(object : TypeToken<ArrayList<Role>>() {}.type, MapSnowflakeToRoleJsonParser(dislin))

    registerTypeAdapterFactory(DislinEntityTypeAdapterFactory(dislin))
}

inline fun <reified T> JsonElement.to(dislin: Dislin): T = DislinData.getGson(dislin).fromJson(this, TypeToken.get(T::class.java).type)
fun <T> JsonElement.toClass(clazz: Class<T>, dislin: Dislin): T = DislinData.getGson(dislin).fromJson(this, TypeToken.get(clazz).type)