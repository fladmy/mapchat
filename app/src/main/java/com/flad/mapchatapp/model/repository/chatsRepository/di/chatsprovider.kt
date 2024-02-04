package com.flad.mapchatapp.model.repository.chatsRepository.di

import com.flad.mapchatapp.model.repository.authrepository.AuthRepository
import com.flad.mapchatapp.model.repository.authrepository.AuthRepositoryMock
import com.flad.mapchatapp.model.repository.chatsRepository.ChatRepository
import com.flad.mapchatapp.model.repository.chatsRepository.ChatRepositoryMock
import com.flad.mapchatapp.model.source.remote.api.auth.AuthRemoteSource
import com.flad.mapchatapp.model.source.remote.api.auth.AuthRemoteSourceMock
import com.flad.mapchatapp.model.source.remote.api.chats.ConversationRemoteSource
import com.flad.mapchatapp.model.source.remote.api.chats.ConversationRemoteSourceMock
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object chatsprovider {

    @Provides
    @Singleton
    fun providerChatRepositoryMock(
        conversationRemoteSource: ConversationRemoteSource
    ): ChatRepository {

        return ChatRepositoryMock(conversationRemoteSource)
    }

    @Provides
    @Singleton
    fun provideConversationSource(): ConversationRemoteSource {
        return ConversationRemoteSourceMock()

    }
}