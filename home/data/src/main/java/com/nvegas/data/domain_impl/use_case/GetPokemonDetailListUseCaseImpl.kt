package com.nvegas.data.domain_impl.use_case

import com.nvegas.data.repository.PokedexRepository
import com.nvegas.domain.models.detail.PokemonDetailModel
import com.nvegas.domain.usecases.GetPokemonDetailListUseCase
import javax.inject.Inject

class GetPokemonDetailListUseCaseImpl @Inject constructor(
    private val repository: PokedexRepository
) : GetPokemonDetailListUseCase {
    override suspend fun invoke(pokemonId: Int): PokemonDetailModel {
        val response = repository.getPokemonDetailFromApi(pokemonId)
        return response
    }
}