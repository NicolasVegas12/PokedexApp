package com.nvegas.data.network.dto.response.detail

import kotlinx.serialization.Serializable

@Serializable
data class PokemonAbilityResponse(
    val ability: PokemonAbilityDetailResponse = PokemonAbilityDetailResponse(),
    val isHidden: Boolean = false,
    val slot: Int = 0

)
