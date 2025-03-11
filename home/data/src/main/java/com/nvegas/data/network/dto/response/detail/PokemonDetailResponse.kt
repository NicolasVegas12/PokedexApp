package com.nvegas.data.network.dto.response.detail

import kotlinx.serialization.Serializable

@Serializable
data class PokemonDetailResponse(
    val id: Int = 0,
    val name: String = "",
    val height: Int = 0,
    val weight: Int = 0,
    val sprites: PokemonSpritesResponse = PokemonSpritesResponse(),
    val abilities: List<PokemonAbilityResponse> = emptyList(),
    val moves: List<PokemonMoveResponse> = emptyList(),
    val types: List<PokemonTypeResponse> = emptyList()
)
