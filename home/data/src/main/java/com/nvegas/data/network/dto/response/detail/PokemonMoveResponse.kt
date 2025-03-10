package com.nvegas.data.network.dto.response.detail

import kotlinx.serialization.Serializable

@Serializable
data class PokemonMoveResponse(
    val move: PokemonMoveDetailResponse = PokemonMoveDetailResponse(),
)
