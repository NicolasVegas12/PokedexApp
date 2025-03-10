package com.nvegas.data.domain_impl.di

import com.nvegas.data.domain_impl.use_case.GetAuthUserUseCaseImpl
import com.nvegas.data.repository.SplashRepository
import com.nvegas.domain.usecases.GetAuthUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SplashUseCaseModule {
    @Provides
    @Singleton
    fun provideGetAuthUserUseCase(
        repository: SplashRepository,
    ): GetAuthUserUseCase = GetAuthUserUseCaseImpl(repository)

}