package com.nvegas.data.network.service

import com.nvegas.data.network.dto.response.detail.PokemonDetailResponse
import com.nvegas.data.network.dto.response.list.PokedexListPagerResponse
import javax.inject.Inject

class PokedexService @Inject constructor(
    private val service: IPokedexService
) {

    suspend fun getPokedexList(offset: Int, limit: Int): PokedexListPagerResponse {

        val result = service.getPokedexList(offset, limit)
        return if (result.isSuccessful) {
            result.body() ?: PokedexListPagerResponse()
        } else {
            PokedexListPagerResponse()
        }
    }

    suspend fun getPokemonDetail(pokemonId: Int): PokemonDetailResponse {
        val result = service.getPokemonDetail(pokemonId)
        return if (result.isSuccessful) {
            result.body() ?: PokemonDetailResponse()
        } else {
            PokemonDetailResponse()
        }
    }


}