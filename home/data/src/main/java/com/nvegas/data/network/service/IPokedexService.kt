package com.nvegas.data.network.service

import com.nvegas.data.network.contract.DataConfigurationContract
import com.nvegas.data.network.dto.response.detail.PokemonDetailResponse
import com.nvegas.data.network.dto.response.list.PokedexListPagerResponse
import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IPokedexService {

    @GET(DataConfigurationContract.API_V2 + DataConfigurationContract.POKEMON_LIST)
    suspend fun getPokedexList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Response<PokedexListPagerResponse>

    @GET(DataConfigurationContract.API_V2 + DataConfigurationContract.POKEMON_DETAIL)
    suspend fun getPokemonDetail(
        @Path("pokemonId") pokemonId: Int
    ):Response<PokemonDetailResponse>
}