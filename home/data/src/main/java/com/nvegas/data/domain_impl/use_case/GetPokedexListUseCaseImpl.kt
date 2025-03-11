package com.nvegas.data.domain_impl.use_case

import com.nvegas.common.utils.IODispatcher
import com.nvegas.data.repository.PokedexRepository
import com.nvegas.domain.models.list.PokedexListPagerModel
import com.nvegas.domain.models.list.PokedexListResultModel
import com.nvegas.domain.usecases.GetPokedexListUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetPokedexListUseCaseImpl @Inject constructor(
    private val repository: PokedexRepository,
    @IODispatcher private val dispatcher: CoroutineDispatcher
) : GetPokedexListUseCase {
    override suspend fun invoke(offset: Int, limit: Int): PokedexListPagerModel =
        withContext(dispatcher) {
            val response: PokedexListPagerModel = repository.getPokedexListFromApi(offset, limit)
            val newList: List<PokedexListResultModel> = response.results.map { result ->
                val detail = repository.getPokemonDetailFromApi(result.id)
                result.copy(detail = detail)
            }
            return@withContext response.copy(results = newList)
        }
}