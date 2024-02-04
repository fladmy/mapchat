package com.flad.mapchatapp.model.source.remote.api.chats

import com.flad.mapchatapp.model.source.remote.api.auth.models.UserDTO
import com.flad.mapchatapp.model.source.remote.api.chats.models.Conversation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ConversationRemoteSourceMock(

): ConversationRemoteSource {
    override suspend fun getAllConversations(userDTO: UserDTO): Flow<List<Conversation>> = flow {
        kotlinx.coroutines.delay(500)

        val conversations = listOf(
            Conversation(id = 1, contactName = "Alice", lastMessage = "Oi, como você está?", timestamp = "2022-07-18T12:00:00Z"),
            Conversation(id = 2, contactName = "Bob", lastMessage = "Você viu a minha mensagem?", timestamp = "2022-07-18T15:30:00Z"),
            Conversation(id = 3, contactName = "Charlie", lastMessage = "Vamos nos encontrar amanhã?", timestamp = "2022-07-19T09:45:00Z")
        )
        emit(conversations)

    }
}