package com.nvegas.data.di

import com.nvegas.core.network.ApiBuilder
import com.nvegas.data.network.service.IPokedexService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeApiProvider {

    private const val API_URL: String = "https://pokeapi.co"

    @Provides
    @Singleton
    fun providesTaskService(): IPokedexService = ApiBuilder.getService(API_URL)

}