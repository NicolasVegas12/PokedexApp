package com.nvegas.data.di

import com.nvegas.data.repository.SignUpRepository
import com.nvegas.data.repository.SignUpRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object SignUpRepositoryProvider {

    @Provides
    @Singleton
    fun provideSignUpRepository(): SignUpRepository = SignUpRepositoryImpl()
}