package com.kodingking.dislin.entities.impl

import com.kodingking.dislin.Dislin
import com.kodingking.dislin.entities.enums.EnumPermission

class Permissions(@Transient val dislin: Dislin, raw: Long) : ArrayList<EnumPermission>() {

    val magic: Long
        get() {
            var current = 0L
            forEach { current = current or it.value }
            return current
        }

    init {
        EnumPermission.values().forEach {
            if ((raw and it.value) == it.value)
                add(it)
        }
    }

    operator fun get(key: EnumPermission) = key in this

}