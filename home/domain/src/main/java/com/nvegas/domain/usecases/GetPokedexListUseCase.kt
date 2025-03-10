package com.nvegas.domain.usecases

import com.nvegas.domain.models.list.PokedexListPagerModel

fun interface GetPokedexListUseCase {

    suspend fun invoke(offset: Int, limit: Int): PokedexListPagerModel
}