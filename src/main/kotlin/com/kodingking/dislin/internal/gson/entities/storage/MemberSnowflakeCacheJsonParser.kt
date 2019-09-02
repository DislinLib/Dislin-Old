package com.kodingking.dislin.internal.gson.entities.storage

import com.google.gson.*
import com.kodingking.dislin.Dislin
import com.kodingking.dislin.DislinData
import com.kodingking.dislin.bot.storage.SnowflakeCache
import com.kodingking.dislin.entities.Member
import java.lang.reflect.Type

class MemberSnowflakeCacheJsonParser(@Transient private val dislin: Dislin) : JsonDeserializer<SnowflakeCache<Member>>, JsonSerializer<SnowflakeCache<Member>> {

    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): SnowflakeCache<Member> {
        val cache = SnowflakeCache<Member>()

        json.asJsonArray.forEach {
            val member = DislinData.getGson(dislin).fromJson(it, Member::class.java)
            cache[member.user.id] = member
        }

        return cache
    }

    override fun serialize(
        src: SnowflakeCache<Member>,
        typeOfSrc: Type,
        context: JsonSerializationContext
    ): JsonElement = DislinData.getGson(dislin).toJsonTree(src.data.values)
}