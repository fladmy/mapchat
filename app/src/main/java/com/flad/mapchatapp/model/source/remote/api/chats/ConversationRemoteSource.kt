package com.flad.mapchatapp.model.source.remote.api.chats

import com.flad.mapchatapp.model.source.remote.api.auth.models.UserDTO
import com.flad.mapchatapp.model.source.remote.api.chats.models.Conversation
import kotlinx.coroutines.flow.Flow

interface ConversationRemoteSource {
    suspend fun getAllConversations(userDTO: UserDTO): Flow<List<Conversation>>
}