package com.kodingking.dislin.bot.storage

import com.kodingking.dislin.entities.Snowflake

class SnowflakeCache<T> {

    val data = hashMapOf<String, T>()

    operator fun set(key: Any, value: T) {
        data[when (key) {
            is String -> key
            is Long -> key.toString()
            is Snowflake -> key.raw
            else -> key.toString()
        }] = value
    }

    operator fun get(key: String) = data[key]
    operator fun get(key: Long) = data[key.toString()]
    operator fun get(key: Snowflake) = data[key.raw]

}