package com.nvegas.data.network.dto.response.detail

import kotlinx.serialization.Serializable

@Serializable
data class PokemonTypeDetailResponse(
    val name: String = "",
    val url: String = ""
)
