package com.nvegas.data.network.dto.response.detail

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonOfficialArtworkResponse(
  @SerialName("front_default")  val frontDefault: String = "",
  @SerialName("front_shiny")  val frontShiny: String = "",
)
