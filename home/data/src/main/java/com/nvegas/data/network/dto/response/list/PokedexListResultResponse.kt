package com.nvegas.data.network.dto.response.list

import kotlinx.serialization.Serializable

@Serializable
data class PokedexListResultResponse(
    val name: String = "",
    val url: String = ""
)