package com.flad.mapchatapp.ui.composables.login


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.flad.mapchatapp.base.BaseViewModel
import com.flad.mapchatapp.model.repository.authrepository.AuthRepository
import com.flad.mapchatapp.model.repository.authrepository.eventhandler.AuthEventAndErrorHandler
import com.flad.mapchatapp.model.repository.authrepository.eventhandler.AuthUiEvent
import com.flad.mapchatapp.model.source.remote.api.auth.models.AuthenticationResponse
import com.flad.mapchatapp.model.source.remote.api.auth.utils.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepositoryMock: AuthRepository
): BaseViewModel<AuthenticationResponse, AuthUiEvent>(){
    var email = mutableStateOf("")
        private set

    var password = mutableStateOf("")
        private set

    var errorMessage = mutableStateOf("")
        private set



    var signInResponse = mutableStateOf<Response<AuthenticationResponse>>(Response.Idle)
        private set

    var authResponseData = mutableStateOf<AuthenticationResponse?>(null)
        private set

    init {
        observAuth()
        obserMessagesOrError()
    }

    private fun obserMessagesOrError() {
        viewModelScope.launch {
            AuthEventAndErrorHandler.eventFlow.collect { authUiEvent->
                emitEvent(authUiEvent)

            }
        }
    }

    private fun observAuth() {
        viewModelScope.launch {
            authRepositoryMock.authenticationResponse.collect { auth ->
                if (auth !== null) {
                    authResponseData.value = auth
                    signInResponse.value = Response.Success(auth)
                }
            }
        }
    }




    fun signInWithEmailAndPassword() = viewModelScope.launch {
        emitEvent(AuthUiEvent.Loading(""))
        val emailVal = email.value
        val passwordVal = password.value

        if (emailVal.isNotEmpty() && passwordVal.isNotEmpty()) {
            authRepositoryMock.backEndAuthWithEmailAndPassword(emailVal, passwordVal)

        } else {
            signInResponse.value =
                Response.Failure(IllegalArgumentException("Email and Password cannot be empty."))
        }
    }

    fun signOut(){
        //_startDestination.value= NumbersAppScreenBar.LogInScreen
        //repo.signOut()
    }

    fun onEmailChange(newEmail: String) {
        email.value = newEmail
    }

    fun onPasswordChange(newPassword: String) {
        password.value = newPassword
    }

    override fun createInitialState(): AuthenticationResponse {
        return AuthenticationResponse()
    }
}