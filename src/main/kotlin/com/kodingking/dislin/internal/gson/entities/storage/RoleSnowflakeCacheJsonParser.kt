package com.kodingking.dislin.internal.gson.entities.storage

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.kodingking.dislin.Dislin
import com.kodingking.dislin.DislinData
import com.kodingking.dislin.bot.storage.SnowflakeCache
import com.kodingking.dislin.entities.Role
import java.lang.reflect.Type

class RoleSnowflakeCacheJsonParser(@Transient private val dislin: Dislin) : JsonDeserializer<SnowflakeCache<Role>> {

    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): SnowflakeCache<Role> {
        val cache = SnowflakeCache<Role>()

        json.asJsonArray.forEach {
            val role = DislinData.getGson(dislin).fromJson(it, Role::class.java)
            dislin.roleCache[role.id] = role
            cache[role.id] = role
        }

        return cache
    }
}