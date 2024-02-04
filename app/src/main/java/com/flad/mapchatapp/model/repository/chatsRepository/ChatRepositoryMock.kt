package com.flad.mapchatapp.model.repository.chatsRepository

import com.flad.mapchatapp.model.repository.authrepository.eventhandler.AuthEventAndErrorHandler
import com.flad.mapchatapp.model.repository.authrepository.eventhandler.AuthUiEvent
import com.flad.mapchatapp.model.source.remote.api.auth.models.UserDTO
import com.flad.mapchatapp.model.source.remote.api.chats.ConversationRemoteSource
import com.flad.mapchatapp.model.source.remote.api.chats.models.Conversation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.io.IOException

class ChatRepositoryMock(
    private val convarsationRemoteSource: ConversationRemoteSource
): ChatRepository {
    private val _conversations = MutableStateFlow<List<Conversation>>(emptyList())
    override val conversations = _conversations.asStateFlow()

    override suspend fun getAllConversations(userDTO: UserDTO){
        try {
            convarsationRemoteSource.getAllConversations(userDTO = userDTO).collect { response ->
                _conversations.value = response
            }
        }catch (exception: IOException){
                AuthEventAndErrorHandler.emitEvent(AuthUiEvent.AuthFail("Auth Fail!"))

            } catch (exception: RuntimeException){
                AuthEventAndErrorHandler.emitEvent(AuthUiEvent.AuthFail("Something Went Wrong!"))
            }

    }
}