package com.nvegas.data.repository

import com.nvegas.domain.models.detail.PokemonDetailModel
import com.nvegas.domain.models.list.PokedexListPagerModel
import com.nvegas.domain.models.list.PokedexListResultModel

interface PokedexRepository {

    suspend fun getPokedexListFromApi(offset: Int, limit: Int): PokedexListPagerModel
    suspend fun getPokemonDetailFromApi(pokemonId: Int): PokemonDetailModel
    suspend fun insertPokemon(pokemon: PokedexListResultModel)
    suspend fun getPokemonCount(): Int

    suspend fun getPokemons(start: Int, end: Int): List<PokedexListResultModel>

}