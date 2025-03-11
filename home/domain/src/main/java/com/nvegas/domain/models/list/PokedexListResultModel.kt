package com.nvegas.domain.models.list

import com.nvegas.domain.models.detail.PokemonDetailModel

data class PokedexListResultModel(
    val id:Int = 0,
    val name: String = "",
    val url: String = "",
    val detail:PokemonDetailModel? = null
)
