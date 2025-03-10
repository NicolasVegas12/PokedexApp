package com.nvegas.data.network.dto.response.detail

import kotlinx.serialization.Serializable

@Serializable
data class PokemonMoveDetailResponse(
    val name:String = "",
    val url:String = ""
)
