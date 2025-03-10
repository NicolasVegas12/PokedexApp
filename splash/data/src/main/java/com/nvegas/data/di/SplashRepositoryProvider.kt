package com.nvegas.data.di

import com.nvegas.data.repository.SplashRepository
import com.nvegas.data.repository.SplashRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SplashRepositoryProvider {
    @Provides
    @Singleton
    fun provideSplashRepository(): SplashRepository = SplashRepositoryImpl()
}