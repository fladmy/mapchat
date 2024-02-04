package com.flad.mapchatapp.model.repository.authrepository

import com.flad.mapchatapp.model.repository.authrepository.eventhandler.AuthEventAndErrorHandler
import com.flad.mapchatapp.model.repository.authrepository.eventhandler.AuthUiEvent
import com.flad.mapchatapp.model.source.remote.api.auth.AuthRemoteSource
import com.flad.mapchatapp.model.source.remote.api.auth.models.AuthenticationResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.io.IOException

class AuthRepositoryMock(
    private val authRemoteSource: AuthRemoteSource

): AuthRepository {
    private val _authenticationResponse = MutableStateFlow<AuthenticationResponse?>(null)
    override val authenticationResponse: StateFlow<AuthenticationResponse?> = _authenticationResponse.asStateFlow()


    override suspend fun backEndAuthWithEmailAndPassword(
        email: String,
        password: String
    ) {
        kotlinx.coroutines.delay(1000L)
        try {
            authRemoteSource.authenticateWithEmailAndPassword(email = email, password = password).collect{
                response->
                _authenticationResponse.value=response
            }

        }catch (exception: IOException){
            AuthEventAndErrorHandler.emitEvent(AuthUiEvent.AuthFail("Auth Fail!"))

        } catch (exception: RuntimeException){
            AuthEventAndErrorHandler.emitEvent(AuthUiEvent.AuthFail("Something Went Wrong!"))
        }
    }
}

