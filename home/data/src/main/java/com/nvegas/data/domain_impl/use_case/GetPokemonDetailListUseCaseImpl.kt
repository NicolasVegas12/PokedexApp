package com.nvegas.data.domain_impl.use_case

import com.nvegas.common.utils.IODispatcher
import com.nvegas.data.repository.PokedexRepository
import com.nvegas.domain.models.detail.PokemonDetailModel
import com.nvegas.domain.usecases.GetPokemonDetailListUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetPokemonDetailListUseCaseImpl @Inject constructor(
    private val repository: PokedexRepository,
    @IODispatcher private val dispatcher: CoroutineDispatcher
) : GetPokemonDetailListUseCase {
    override suspend fun invoke(pokemonId: Int): PokemonDetailModel = withContext(dispatcher) {
        val response = repository.getPokemonDetailFromApi(pokemonId)
        return@withContext response
    }
}