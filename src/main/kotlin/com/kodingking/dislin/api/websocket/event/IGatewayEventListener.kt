package com.kodingking.dislin.api.websocket.event

import com.kodingking.dislin.api.websocket.entities.*
import com.kodingking.dislin.entities.*

interface IGatewayEventListener {

    fun onReady(readyData: ReadyData)
    fun onResumed()
    fun onInvalidSession()

    fun onChannelCreate(channel: Channel)
    fun onChannelUpdate(channel: Channel)
    fun onChannelDelete(channel: Channel)
    fun onChannelPinsUpdate(data: ChannelPinsUpdateData)

    fun onGuildCreate(guild: Guild)
    fun onGuildUpdate(guild: Guild)
    fun onGuildDelete(guild: Guild)
    fun onGuildBanAdd(data: GuildBanData)
    fun onGuildBanRemove(data: GuildBanData)
    fun onGuildEmojisUpdate(data: GuildEmojisUpdateData)
    fun onGuildIntegrationsUpdate(data: GuildIntegrationsUpdateData)
    fun onGuildMemberAdd(member: Member)
    fun onGuildMemberRemove(data: GuildMemberRemoveData)
    fun onGuildMemberUpdate(data: GuildMemberUpdateData)
    fun onGuildMembersChunk(data: GuildMembersChunkData)
    fun onGuildRoleCreate(data: GuildRoleData)
    fun onGuildRoleUpdate(data: GuildRoleData)
    fun onGuildRoleDelete(data: GuildRoleDeleteData)

    fun onMessageCreate(message: Message)
    fun onMessageUpdate(message: Message)
    fun onMessageDelete(data: MessageDeleteData)
    fun onMessageDeleteBulk(data: MessageDeleteBulkData)
    fun onMessageReactionAdd(data: MessageReactionData)
    fun onMessageReactionRemove(data: MessageReactionData)
    fun onMessageReactionRemoveAll(data: MessageReactionRemoveAllData)

    fun onPresenceUpdate(presence: Presence)
    fun onTypingStart(data: TypingStartData)
    fun onUserUpdate(user: User)

    fun onVoiceStateUpdate(state: VoiceState)
    fun onVoiceServerUpdate(data: VoiceServerUpdateData)

    fun onWebhooksUpdate(data: WebhooksUpdateData)

}