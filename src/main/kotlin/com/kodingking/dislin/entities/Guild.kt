package com.kodingking.dislin.entities

import com.google.gson.annotations.SerializedName
import com.kodingking.dislin.Dislin
import com.kodingking.dislin.bot.storage.SnowflakeCache

class Guild(
    dislin: Dislin,
    val id: Snowflake,
    val name: String,
    val icon: String,
    val splash: String,
    val owner: Boolean?,
    @SerializedName("owner_id") val ownerId: Snowflake,
    val permissions: Int?,
    val region: String,
    @SerializedName("afk_channel_id") val afkChannelId: Snowflake?,
    @SerializedName("afk_timeout") val afkTimeout: Int,
    @SerializedName("embed_enabled") val embedEnabled: Boolean?,
    @SerializedName("embed_channel_id") val embedChannelId: Snowflake?,
    @SerializedName("verification_level") val verificationLevel: Int,
    @SerializedName("default_message_notifications") val defaultMessageNotifications: Int,
    @SerializedName("explicit_content_filter") val explicitContentFilter: Int,
    val roles: SnowflakeCache<Role>,
    val emojis: ArrayList<Emoji>,
    val features: ArrayList<String>,
    @SerializedName("mfa_level") val mfaLevel: Int,
    @SerializedName("application_id") val applicationId: Snowflake?,
    @SerializedName("widget_enabled") val widgetEnabled: Boolean?,
    @SerializedName("widget_channel_id") val widgetChannelId: Snowflake?,
    @SerializedName("system_channel_id") val systemChannelId: Snowflake?,
    @SerializedName("joined_at") val joinedAt: String?,
    val large: Boolean?,
    val unavailable: Boolean?,
    @SerializedName("member_count") val memberCount: Int?,
    @SerializedName("voice_states") val voiceStates: ArrayList<VoiceState>,
    val members: SnowflakeCache<Member>,
    @SerializedName("channels") private val initialChannels: ArrayList<Channel>,
    val presences: ArrayList<Presence>,
    @SerializedName("max_presences") val maxPresences: Int?,
    @SerializedName("max_members") val maxMembers: Int?,
    @SerializedName("vanity_url_code") val vanityUrlCode: String?,
    val description: String?,
    val banner: String?,
    @SerializedName("premium_tier") val premiumTier: Int,
    @SerializedName("premium_subscription_count") val premiumSubscriptionCount: Int?,
    @SerializedName("preferred_locale") val preferredLocale: String
) : DislinEntity(dislin) {

    var messageCache: SnowflakeCache<Message> = SnowflakeCache()

}