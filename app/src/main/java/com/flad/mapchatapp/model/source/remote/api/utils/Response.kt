package com.flad.mapchatapp.model.source.remote.api.utils

sealed class Response<out T> {
    object Loading: Response<Nothing>()
    object Idle: Response<Nothing>()

    data class Success<out T>(
        val data: T
    ): Response<T>()

    data class Failure(
        val e: Exception
    ): Response<Nothing>()
}