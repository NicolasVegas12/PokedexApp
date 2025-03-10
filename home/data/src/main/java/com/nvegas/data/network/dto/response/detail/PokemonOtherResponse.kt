package com.nvegas.data.network.dto.response.detail

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonOtherResponse(
    @SerialName("official-artwork") val officialArtwork: PokemonOfficialArtworkResponse = PokemonOfficialArtworkResponse()
)
