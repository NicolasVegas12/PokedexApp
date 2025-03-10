package com.nvegas.domain.usecases

import com.nvegas.domain.models.detail.PokemonDetailModel

fun interface GetPokemonDetailListUseCase {
    suspend fun invoke(pokemonId: Int): PokemonDetailModel

}