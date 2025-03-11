package com.nvegas.data.domain_impl.use_case

import android.util.Log
import com.nvegas.common.utils.IODispatcher
import com.nvegas.data.repository.PokedexRepository
import com.nvegas.data.repository.app.AppRepository
import com.nvegas.domain.models.list.PokedexListPagerModel
import com.nvegas.domain.models.list.PokedexListResultModel
import com.nvegas.domain.usecases.GetPokedexListUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetPokedexListUseCaseImpl @Inject constructor(
    private val repository: PokedexRepository,
    private val appRepository: AppRepository,
    @IODispatcher private val dispatcher: CoroutineDispatcher
) : GetPokedexListUseCase {
    override suspend fun invoke(offset: Int, limit: Int): PokedexListPagerModel =
        withContext(dispatcher) {

            val connected = appRepository.isInternetAvailable().first()
            val pokemonCount = repository.getPokemonCount()
            val end = offset + limit
            val response: PokedexListPagerModel = if (pokemonCount < end+1) {
                if (connected) {
                    val list = repository.getPokedexListFromApi(offset, limit)
                    val newList: List<PokedexListResultModel> = list.results.map { result ->
                        val detail = repository.getPokemonDetailFromApi(result.id)
                        result.copy(detail = detail)
                    }
                    newList.map {
                        repository.insertPokemon(it)
                    }
                    list.copy(results = newList)
                } else {
                    PokedexListPagerModel(
                        count = pokemonCount,
                        next = null,
                        previous = "",
                        results = emptyList()
                    )
                }


            } else {
                val list = repository.getPokemons(offset+1, end )
                PokedexListPagerModel(
                    count = pokemonCount,
                    next = if (end == pokemonCount) null else "",
                    previous = if (offset == 0) null else "",
                    results = list
                )
            }
            response.results.map {

                Log.d("GetPokedexListUseCaseImpl", "invoke: $it")
            }
            return@withContext response
        }
}