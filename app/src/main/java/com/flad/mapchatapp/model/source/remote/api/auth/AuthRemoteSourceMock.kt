package com.flad.mapchatapp.model.source.remote.api.auth

import com.flad.mapchatapp.model.source.remote.api.auth.models.AuthenticationResponse
import com.flad.mapchatapp.model.source.remote.api.auth.models.UserDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.UUID

class AuthRemoteSourceMock: AuthRemoteSource {

    override suspend fun authenticateWithEmailAndPassword(email: String, password: String): Flow<AuthenticationResponse> = flow {
        // Simula resposta mock
        kotlinx.coroutines.delay(500)
        emit(
            AuthenticationResponse(
            accessToken = "mock_access_token_123456",
            refreshToken = "mock_refresh_token_123456",
            user = UserDTO(id = UUID.randomUUID(), email = "mockemail@example.com")
        )
        )
    }
}