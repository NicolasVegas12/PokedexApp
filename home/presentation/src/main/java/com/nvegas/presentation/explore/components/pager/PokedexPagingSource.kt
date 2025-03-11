package com.nvegas.presentation.explore.components.pager

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.nvegas.domain.models.list.PokedexListResultModel
import com.nvegas.domain.usecases.GetPokedexListUseCase

class PokedexPagingSource(
    private val getPokedexListUseCase: GetPokedexListUseCase
) :
    PagingSource<Int, PokedexListResultModel>() {
    override fun getRefreshKey(state: PagingState<Int, PokedexListResultModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PokedexListResultModel> {
        val page = params.key ?: 1

        val response = getPokedexListUseCase.invoke(
            offset = (page - 1) * 20,
            limit = 20
        )

        return LoadResult.Page(
            data = response.results,
            nextKey = response.next?.let { page + 1 },
            prevKey = response.previous?.let { page - 1 }
        )
    }
}