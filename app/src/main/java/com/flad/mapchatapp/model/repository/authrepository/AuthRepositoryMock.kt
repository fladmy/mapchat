package com.flad.mapchatapp.model.repository.authrepository

import android.net.http.HttpException
import com.flad.mapchatapp.model.source.remote.api.models.auth.AuthenticationResponse
import com.flad.mapchatapp.model.source.remote.api.models.auth.UserDTO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.time.delay
import java.io.IOException
import java.util.UUID

class AuthRepositoryMock(

): AuthRepository {
    private val _authenticationResponse = MutableStateFlow<AuthenticationResponse?>(null)
    override val authenticationResponse: StateFlow<AuthenticationResponse?> = _authenticationResponse.asStateFlow()


    override suspend fun backEndAuthWithEmailAndPassword(
        email: String,
        password: String
    ) {
        kotlinx.coroutines.delay(2000L)
        try {
            _authenticationResponse.value=
                AuthenticationResponse(
                    accessToken = "123456",
                    refreshToken = "123456",
                    user = UserDTO(id = UUID.randomUUID(), email = "flad@gmail.com"))

        }catch (exception: Exception){
            //ventAndErrorHandle.emitEvent(UiEventAuthBackEnd.AuthFail("Auth Fail!"))

        }catch (exception: IOException){
            //EventAndErrorHandle.emitEvent(UiEventAuthBackEnd.AuthFail("Network Fail!"))
        } catch (exception: RuntimeException){
           // EventAndErrorHandle.emitEvent(UiEventAuthBackEnd.AuthFail("Something Went Wrong!"))
        }
    }
}

