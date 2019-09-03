package com.kodingking.dislin.entities.impl

import com.kodingking.dislin.Dislin
import com.kodingking.dislin.entities.raw.ActivityRaw

class Activity(@Transient val dislin: Dislin, raw: ActivityRaw = ActivityRaw()) {

    var name = raw.name
    var type = raw.type

}