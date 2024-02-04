package com.flad.mapchatapp.model.repository.authrepository.di

import com.flad.mapchatapp.model.repository.authrepository.AuthRepository
import com.flad.mapchatapp.model.repository.authrepository.AuthRepositoryMock
import com.flad.mapchatapp.model.source.remote.api.auth.AuthRemoteSource
import com.flad.mapchatapp.model.source.remote.api.auth.AuthRemoteSourceMock
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object authprovider {

    @Provides
    @Singleton
    fun provideAuthRepositoryMock(
        authRemoteSource: AuthRemoteSource
    ): AuthRepository {
        // Aqui você deve retornar a implementação de BackEndAuthRepository
        return AuthRepositoryMock(authRemoteSource)
    }

    @Provides
    @Singleton
    fun provideAuthRemoteSource(): AuthRemoteSource {
        return AuthRemoteSourceMock()

    }
}