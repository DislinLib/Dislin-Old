package com.kodingking.dislin.entities.impl

import com.kodingking.dislin.Dislin
import com.kodingking.dislin.entities.raw.MemberRaw

class Member(@Transient val dislin: Dislin, @Transient val guild: Guild, raw: MemberRaw) {

    var nickname = raw.nick

    val roles = arrayListOf<Role>()

    var user = User(dislin, raw.user)

    val effectiveName: String
        get() = nickname ?: user.username

    val permissions: Permissions
        get() {
            var magic = 0L
            roles.forEach { magic = magic or it.permissions.magic }
            return Permissions(dislin, magic)
        }

    init {
        raw.roles.forEach { roles.add(guild.roles[it] ?: return@forEach) }
    }

}