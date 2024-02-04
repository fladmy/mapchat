package com.flad.mapchatapp.model.source.remote.api.auth.models

import java.util.UUID

data class UserDTO(
    val id: UUID,
    val email: String
)

