package com.kodingking.dislin.entities.dsl

import com.kodingking.dislin.Dislin
import com.kodingking.dislin.entities.enums.EnumActivityType
import com.kodingking.dislin.entities.impl.Activity
import com.kodingking.dislin.entities.raw.ActivityRaw

@DslMarker
annotation class ActivityDSL

@ActivityDSL
fun activity(dislin: Dislin, build: Activity.() -> Unit): Activity {
    val activity = Activity(dislin)
    activity.build()
    return activity
}

fun activity(dislin: Dislin, name: String, type: EnumActivityType = EnumActivityType.GAME) =
    Activity(dislin, ActivityRaw(name, type))