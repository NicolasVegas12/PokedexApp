package com.nvegas.data.repository

import com.nvegas.data.mappers.toDomain
import com.nvegas.data.network.service.PokedexService
import com.nvegas.domain.models.detail.PokemonDetailModel
import com.nvegas.domain.models.list.PokedexListPagerModel
import javax.inject.Inject

class PokedexRepositoryImpl @Inject constructor(
    private val api: PokedexService
) : PokedexRepository {
    override suspend fun getPokedexListFromApi(offset: Int, limit: Int): PokedexListPagerModel =
        api.getPokedexList(offset, limit).toDomain()

    override suspend fun getPokemonDetailFromApi(pokemonId: Int): PokemonDetailModel {
        val response = api.getPokemonDetail(pokemonId)
        return response.toDomain()
    }


}