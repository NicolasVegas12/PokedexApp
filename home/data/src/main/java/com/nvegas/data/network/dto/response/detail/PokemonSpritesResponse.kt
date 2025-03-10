package com.nvegas.data.network.dto.response.detail

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonSpritesResponse(
    @SerialName("front_default") val frontDefault: String = "",
    @SerialName("other") val other: PokemonOtherResponse = PokemonOtherResponse(),

)
