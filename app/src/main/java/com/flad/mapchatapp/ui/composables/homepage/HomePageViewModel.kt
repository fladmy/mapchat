package com.flad.mapchatapp.ui.composables.homepage

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.flad.mapchatapp.base.BaseViewModel
import com.flad.mapchatapp.model.repository.authrepository.AuthRepository
import com.flad.mapchatapp.model.repository.authrepository.eventhandler.AuthEventAndErrorHandler
import com.flad.mapchatapp.model.repository.authrepository.eventhandler.AuthUiEvent
import com.flad.mapchatapp.model.repository.chatsRepository.ChatRepository
import com.flad.mapchatapp.model.source.remote.api.auth.models.AuthenticationResponse
import com.flad.mapchatapp.model.source.remote.api.auth.utils.Response
import com.flad.mapchatapp.model.viewdatainterfaces.IViewEvent
import com.flad.mapchatapp.model.source.remote.api.chats.models.Conversation
import com.flad.mapchatapp.model.source.remote.api.chats.models.ConversationsState

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomePageViewModel @Inject constructor(
    private val authRepositoryMock: AuthRepository,
    private val chatRepository: ChatRepository
): BaseViewModel<ConversationsState, AuthUiEvent>() {

    var authResponseData = mutableStateOf<AuthenticationResponse?>(null)
        private set
    override fun createInitialState(): ConversationsState {
        return ConversationsState(
            conversations = listOf(
                Conversation(id = 1, contactName = "Alice", lastMessage = "Oi, como você está?", timestamp = "2022-07-18T12:00:00Z")
            ))
    }

    init {
        observAuth()
        obserMessagesOrError()
        loadConversations()
    }

    private fun observAuth() {
        viewModelScope.launch {
            authRepositoryMock.authenticationResponse.collect { auth ->
                if (auth !== null) {
                    authResponseData.value = auth
                    chatRepository.getAllConversations(auth.user)

                }
            }
        }
    }

    private fun obserMessagesOrError() {
        viewModelScope.launch {
            AuthEventAndErrorHandler.eventFlow.collect { authUiEvent->
                emitEvent(authUiEvent)

            }
        }
    }
    private fun loadConversations(){
        viewModelScope.launch {
            chatRepository.conversations.collect{conversationList->
                setState { copy(conversations = conversationList)}

            }
        }
    }


}