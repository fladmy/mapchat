package com.flad.mapchatapp.model.source.remote.api.models.auth


import com.flad.mapchatapp.model.viewdatainterfaces.IViewState
import java.util.UUID

data class AuthenticationResponse (
    val accessToken: String= "",
    val refreshToken: String= "",
    val user: UserDTO=UserDTO(id = UUID.randomUUID(), email = "")
): IViewState