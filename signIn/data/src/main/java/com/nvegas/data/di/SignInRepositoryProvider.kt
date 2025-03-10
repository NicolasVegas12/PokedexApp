package com.nvegas.data.di

import com.nvegas.data.repository.SignInRepository
import com.nvegas.data.repository.SignInRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object SignInRepositoryProvider {

    @Provides
    @Singleton
    fun provideSignInRepository(): SignInRepository = SignInRepositoryImpl()
}