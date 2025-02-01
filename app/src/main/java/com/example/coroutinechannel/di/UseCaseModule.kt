package com.example.coroutinechannel.di

import com.example.coroutinechannel.data.network.datasource.remote.repository.Repository
import com.example.coroutinechannel.data.network.datasource.remote.usecase.AuthUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideAuthUseCase(repository: Repository): AuthUseCase {
        return AuthUseCase(repository)
    }

}