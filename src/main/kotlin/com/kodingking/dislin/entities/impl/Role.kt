package com.kodingking.dislin.entities.impl

import com.kodingking.dislin.Dislin
import com.kodingking.dislin.entities.raw.RoleRaw

class Role(@Transient val dislin: Dislin, @Transient val guild: Guild, raw: RoleRaw) {

    val id = raw.id
    val managed = raw.managed

    var name = raw.name
    var color = raw.color
    var hoisted = raw.hoist
    var position = raw.position
    var mentionable = raw.mentionable
    var permissions = Permissions(dislin, raw.permissions)

}