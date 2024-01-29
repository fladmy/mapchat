package com.flad.mapchatapp.model.repository.authrepository.eventhandler

import com.flad.mapchatapp.model.viewdatainterfaces.IViewEvent


sealed class AuthUiEvent: IViewEvent {
    data class AuthFail(val message: String):AuthUiEvent()
    data class Loading(val message: String):AuthUiEvent()
    data class InitialState(val message: String):AuthUiEvent()
}