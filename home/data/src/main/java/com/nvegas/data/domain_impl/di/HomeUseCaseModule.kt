package com.nvegas.data.domain_impl.di

import com.nvegas.common.utils.IODispatcher
import com.nvegas.data.domain_impl.use_case.GetPokedexListUseCaseImpl
import com.nvegas.data.domain_impl.use_case.GetPokemonDetailListUseCaseImpl
import com.nvegas.data.repository.PokedexRepository
import com.nvegas.domain.usecases.GetPokedexListUseCase
import com.nvegas.domain.usecases.GetPokemonDetailListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeUseCaseModule {
    @Provides
    @Singleton
    fun provideGetPokedexUseCase(
        repository: PokedexRepository,
        @IODispatcher dispatcher: CoroutineDispatcher
    ): GetPokedexListUseCase = GetPokedexListUseCaseImpl(repository, dispatcher)

    @Provides
    @Singleton
    fun provideGetPokemonDetailUseCase(
        repository: PokedexRepository,
        @IODispatcher dispatcher: CoroutineDispatcher
    ): GetPokemonDetailListUseCase = GetPokemonDetailListUseCaseImpl(repository, dispatcher)

}