package com.kodingking.dislin.internal.gson.entities.mapping

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.kodingking.dislin.Dislin
import com.kodingking.dislin.entities.Role
import java.lang.reflect.Type

class MapSnowflakeToRoleJsonParser(@Transient private val dislin: Dislin) : JsonDeserializer<ArrayList<Role>> {

    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): ArrayList<Role> {
        val list = arrayListOf<Role>()
        val roles = json.asJsonArray ?: return list

        roles.forEach {
            val snowflake = it.asString
            list.add(dislin.roleCache[snowflake] ?: return@forEach)
        }

        return list
    }
}