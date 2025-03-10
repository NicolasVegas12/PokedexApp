package com.nvegas.data.network.dto.response.list

import kotlinx.serialization.Serializable

@Serializable
data class PokedexListPagerResponse(
    val count: Int = 0,
    val next: String? = null,
    val previous: String? = null,
    val results: List<PokedexListResultResponse> = emptyList()
)