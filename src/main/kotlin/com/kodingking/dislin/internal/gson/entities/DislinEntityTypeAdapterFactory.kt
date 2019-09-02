package com.kodingking.dislin.internal.gson.entities

import com.google.gson.Gson
import com.google.gson.TypeAdapter
import com.google.gson.TypeAdapterFactory
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import com.kodingking.dislin.Dislin
import com.kodingking.dislin.entities.DislinEntity
import java.io.IOException
import java.lang.reflect.Field

class DislinEntityTypeAdapterFactory(private val dislin: Dislin) : TypeAdapterFactory {

    private val dislinField: Field = DislinEntity::class.java.getDeclaredField("dislin")

    init {
        dislinField.isAccessible = true
    }

    override fun <T> create(gson: Gson, type: TypeToken<T>): TypeAdapter<T> {
        val delegate = gson.getDelegateAdapter(this, type)

        return object : TypeAdapter<T>() {

            @Throws(IOException::class)
            override fun write(out: JsonWriter, value: T) {
                delegate.write(out, value)
            }

            @Throws(IOException::class)
            override fun read(`in`: JsonReader): T {
                val obj = delegate.read(`in`)

                if (obj is DislinEntity) {
                    dislinField.set(obj, dislin)
                }

                return obj
            }
        }
    }
}