package com.nvegas.data.repository

import com.nvegas.domain.models.detail.PokemonDetailModel
import com.nvegas.domain.models.list.PokedexListPagerModel

interface PokedexRepository {

    suspend fun getPokedexListFromApi(offset: Int, limit: Int): PokedexListPagerModel
    suspend fun getPokemonDetailFromApi(pokemonId: Int): PokemonDetailModel


}