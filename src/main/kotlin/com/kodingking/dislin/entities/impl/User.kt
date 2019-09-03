package com.kodingking.dislin.entities.impl

import com.kodingking.dislin.Dislin
import com.kodingking.dislin.entities.raw.UserRaw

open class User(@Transient val dislin: Dislin, raw: UserRaw) {

    val id = raw.id
    val bot = raw.bot ?: false
//    val flags = arrayListOf<EnumUserFlags>()

    var username = raw.username
    var discriminator = raw.discriminator
    var mfaEnabled = raw.mfaEnabled ?: false
//    var premiumType = raw.premiumType

    private var avatarHash = raw.avatar

    private val avatarUrl: String
        get() = "https://cdn.discordapp.com/avatars/${id.raw}/$avatarHash${if (avatarHash?.startsWith("a_") == true) ".gif" else ".png"}"
    private val defaultAvatarUrl: String
        get() = "https://cdn.discordapp.com/embed/avatars/${id.raw}/${discriminator.toInt() % 5}"
    val effectiveAvatarUrl: String
        get() = if (avatarHash == null) defaultAvatarUrl else avatarUrl

}