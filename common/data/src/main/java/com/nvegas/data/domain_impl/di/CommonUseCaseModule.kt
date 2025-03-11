package com.nvegas.data.domain_impl.di

import com.nvegas.data.domain_impl.use_cases.GetConnectivityUseCaseImpl
import com.nvegas.data.repository.app.AppRepository
import com.nvegas.domain.usecases.GetConnectivityUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CommonUseCaseModule {

    @Provides
    @Singleton
    fun provideGetConnectivityUseCase(
        appRepository: AppRepository,
    ): GetConnectivityUseCase = GetConnectivityUseCaseImpl(appRepository)
}