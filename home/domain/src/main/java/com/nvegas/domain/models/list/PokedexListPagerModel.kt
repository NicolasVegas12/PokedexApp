package com.nvegas.domain.models.list

data class PokedexListPagerModel(
    val count: Int = 0,
    val next: String? = null,
    val previous: String? = null,
    val results: List<PokedexListResultModel> = emptyList()

)
