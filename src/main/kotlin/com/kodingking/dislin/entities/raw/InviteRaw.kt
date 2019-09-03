package com.kodingking.dislin.entities.raw

import com.google.gson.annotations.SerializedName

data class InviteRaw(
    val code: String,
    val guild: GuildRaw,
    val channel: ChannelRaw,
    @SerializedName("target_user") val targetUser: UserRaw,
    @SerializedName("target_user_type") val targetUserType: Int,
    @SerializedName("approximate_presence_count") val approximatePresenceCount: Int,
    @SerializedName("approximate_member_count") val approximateMemberCount: Int
)