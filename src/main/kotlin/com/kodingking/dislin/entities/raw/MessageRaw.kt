package com.kodingking.dislin.entities.raw

import com.google.gson.annotations.SerializedName
import com.kodingking.dislin.entities.Snowflake

data class MessageRaw(
    val id: Snowflake,
    @SerializedName("channel_id") val channelId: Snowflake,
    @SerializedName("guild_id") val guildId: Snowflake?,
    val author: UserRaw?,
    val member: MemberRaw?,
    val content: String,
    val timestamp: String,
    @SerializedName("edited_timestamp") val editedTimestamp: String,
    val tts: Boolean,
    @SerializedName("mention_everyone") val mentionEveryone: Boolean,
    val mentions: ArrayList<UserRaw>,
    @SerializedName("mention_roles") val mentionRoles: ArrayList<RoleRaw>,
    val attachments: ArrayList<AttachmentRaw>,
    val embeds: ArrayList<EmbedRaw>,
    val reactions: ArrayList<ReactionRaw>?,
    val nonce: Snowflake?,
    val pinned: Boolean,
    @SerializedName("webhook_id") val webhookId: Snowflake?,
    val type: Int,
    val activity: ActivityRaw?,
    val application: MessageApplicationRaw,
    @SerializedName("message_reference") val messageReference: MessageReferenceRaw,
    val flags: Int?
)