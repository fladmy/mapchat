package com.flad.mapchatapp.model.repository.authrepository.di

import com.flad.mapchatapp.model.repository.authrepository.AuthRepository
import com.flad.mapchatapp.model.repository.authrepository.AuthRepositoryMock
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
    fun provideAuthRepositoryMock(): AuthRepository {
        // Aqui você deve retornar a implementação de BackEndAuthRepository
        return AuthRepositoryMock()
    }
}