package com.nvegas.data.network.dto.response.detail

import kotlinx.serialization.Serializable

@Serializable
data class PokemonTypeResponse(

    val slot:Int = 0,
    val type: PokemonTypeDetailResponse = PokemonTypeDetailResponse()

)