package com.nvegas.data.di

import com.nvegas.data.database.dao.PokemonDao
import com.nvegas.data.network.service.PokedexService
import com.nvegas.data.repository.PokedexRepository
import com.nvegas.data.repository.PokedexRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeRepositoryProvider {
    @Provides
    @Singleton
    fun providePokedexRepository(api:PokedexService, pokemonDao: PokemonDao): PokedexRepository = PokedexRepositoryImpl(api,pokemonDao)
}