package com.flad.mapchatapp.model.source.remote.api.models.auth

import java.util.UUID

data class UserDTO(
    val id: UUID,
    val email: String
)

