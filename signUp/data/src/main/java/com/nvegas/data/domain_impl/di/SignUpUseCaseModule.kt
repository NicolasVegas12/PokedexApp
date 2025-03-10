package com.nvegas.data.domain_impl.di

import com.nvegas.common.utils.IODispatcher
import com.nvegas.data.domain_impl.use_case.SignUpUseCaseImpl
import com.nvegas.data.repository.SignUpRepository
import com.nvegas.domain.usecases.SignUpUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SignUpUseCaseModule {

    @Provides
    @Singleton
    fun provideSignUpUseCase(
        repository: SignUpRepository,
        @IODispatcher dispatcher: CoroutineDispatcher
    ): SignUpUseCase = SignUpUseCaseImpl(repository,dispatcher)
}