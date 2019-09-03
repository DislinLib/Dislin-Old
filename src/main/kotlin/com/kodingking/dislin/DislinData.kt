package com.kodingking.dislin

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.kodingking.dislin.internal.ext.components

object DislinData {

    private val gsonCache = hashMapOf<Dislin, Gson>()

    fun getGson(dislin: Dislin) = gsonCache.getOrPut(dislin) {
        GsonBuilder().apply {
            serializeNulls()
            components()
        }.create()
    }

}