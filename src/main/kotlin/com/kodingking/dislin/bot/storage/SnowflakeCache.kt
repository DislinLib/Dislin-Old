package com.kodingking.dislin.bot.storage

import com.kodingking.dislin.entities.Snowflake

class SnowflakeCache<T> : HashMap<String, T>() {

    operator fun set(key: Any, value: T) {
        put(
            when (key) {
                is String -> key
                is Long -> key.toString()
                is Snowflake -> key.raw
                else -> key.toString()
            }, value
        )
    }

    operator fun get(key: Long) = get(key.toString())
    operator fun get(key: Snowflake) = get(key.raw)

    fun remove(key: Long) = remove(key.toString())
    fun remove(key: Snowflake) = remove(key.raw)

}