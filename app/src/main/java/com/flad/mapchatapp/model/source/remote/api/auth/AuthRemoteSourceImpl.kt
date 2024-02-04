package com.flad.mapchatapp.model.source.remote.api.auth

import com.flad.mapchatapp.model.source.remote.api.auth.models.AuthenticationResponse
import com.flad.mapchatapp.model.source.remote.api.auth.models.UserDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.UUID

class AuthRemoteSourceImpl: AuthRemoteSource {

    override suspend fun authenticateWithEmailAndPassword(email: String, password: String): Flow<AuthenticationResponse> = flow {
        // Simula chamada de rede
        kotlinx.coroutines.delay(2000)
        emit(
            AuthenticationResponse(
            accessToken = "real_access_token_123456",
            refreshToken = "real_refresh_token_123456",
            user = UserDTO(id = UUID.randomUUID(), email = email)
        )
        )
    }
}