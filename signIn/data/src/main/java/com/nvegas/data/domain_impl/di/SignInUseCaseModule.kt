package com.nvegas.data.domain_impl.di

import com.nvegas.common.utils.IODispatcher
import com.nvegas.data.domain_impl.use_case.SignInUseCaseImpl
import com.nvegas.data.domain_impl.use_case.SignOutUseCaseImpl
import com.nvegas.data.repository.SignInRepository
import com.nvegas.domain.usecases.SignInUseCase
import com.nvegas.domain.usecases.SignOutUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SignInUseCaseModule {

    @Provides
    @Singleton
    fun provideSignInUseCase(
        repository: SignInRepository,
        @IODispatcher dispatcher: CoroutineDispatcher
    ): SignInUseCase = SignInUseCaseImpl(repository, dispatcher)

    @Provides
    @Singleton
    fun provideSignOutUseCase(
        repository: SignInRepository,
    ): SignOutUseCase = SignOutUseCaseImpl(repository)
}