package com.nvegas.domain.models.detail

data class PokemonDetailModel(
    val id: Int = 0,
    val name: String = "",
    val height: Int = 0,
    val weight: Int = 0,
    val sprites: PokemonSpritesModel = PokemonSpritesModel(),
    val abilities: List<PokemonAbilityModel> = emptyList(),
    val moves: List<PokemonMoveModel> = emptyList(),
    val types: List<PokemonTypeModel> = emptyList()
)
