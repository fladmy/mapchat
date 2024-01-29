package com.flad.mapchatapp.model.repository.authrepository.eventhandler

import android.util.Log
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

object AuthEventAndErrorHandler {
    private val _eventFlow = MutableSharedFlow<AuthUiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    suspend fun emitEvent(event: AuthUiEvent) {
        _eventFlow.emit(event)
        logEvent(event)
    }

    private fun logEvent(event: AuthUiEvent) {
        when (event) {
            is AuthUiEvent.AuthFail -> Log.e(
                "EventAndErrorHandle",
                "Auth FAiled!: ${event.message}"
            )

            else -> {}
        }
    }
}