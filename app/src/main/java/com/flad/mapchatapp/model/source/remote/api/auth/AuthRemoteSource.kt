package com.flad.mapchatapp.model.source.remote.api.auth

import com.flad.mapchatapp.model.source.remote.api.auth.models.AuthenticationResponse
import kotlinx.coroutines.flow.Flow

interface AuthRemoteSource {
    suspend fun authenticateWithEmailAndPassword(email: String, password: String): Flow<AuthenticationResponse>
}