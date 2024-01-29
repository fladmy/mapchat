package com.flad.mapchatapp.model.repository.authrepository

import com.flad.mapchatapp.model.source.remote.api.models.auth.AuthenticationResponse
import kotlinx.coroutines.flow.StateFlow

interface AuthRepository {
    val authenticationResponse: StateFlow<AuthenticationResponse?>

    suspend fun backEndAuthWithEmailAndPassword(email: String, password: String)
}