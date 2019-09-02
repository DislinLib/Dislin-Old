package com.kodingking.dislin.entities

import com.google.gson.annotations.SerializedName
import com.kodingking.dislin.Dislin

class Message(
    dislin: Dislin,
    val id: Snowflake,
    @SerializedName("channel_id") private val channelId: Snowflake,
    @SerializedName("guild_id") private val guildId: Snowflake?,
    val author: User?,
    val member: Member?,
    val content: String,
    val timestamp: String,
    @SerializedName("edited_timestamp") val editedTimestamp: String,
    val tts: Boolean,
    @SerializedName("mention_everyone") val mentionEveryone: Boolean,
    val mentions: ArrayList<User>,
    @SerializedName("mention_roles") val mentionRoles: ArrayList<Role>,
    val attachments: ArrayList<Attachment>,
    val embeds: ArrayList<Embed>,
    val reactions: ArrayList<Reaction>?,
    val nonce: Snowflake?,
    val pinned: Boolean,
    @SerializedName("webhook_id") val webhookId: Snowflake?,
    val type: Int,
    val activity: Activity?,
    val application: MessageApplication,
    @SerializedName("message_reference") val messageReference: MessageReference,
    val flags: Int?
) : DislinEntity(dislin) {

    var guild: Guild? = null
        get() {
            return dislin.guildCache[guildId ?: return null]
        }
        private set
}