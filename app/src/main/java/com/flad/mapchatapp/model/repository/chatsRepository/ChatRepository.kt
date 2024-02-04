package com.flad.mapchatapp.model.repository.chatsRepository

import com.flad.mapchatapp.model.source.remote.api.auth.models.UserDTO
import com.flad.mapchatapp.model.source.remote.api.chats.models.Conversation


import kotlinx.coroutines.flow.StateFlow

interface ChatRepository {
    val conversations: StateFlow<List<Conversation>>

    suspend fun getAllConversations(userDTO: UserDTO)
}