package com.nvegas.data.database.entity.relations

import androidx.room.Entity

@Entity(primaryKeys = ["pokemonId", "moveId"])
data class PokemonMoveCrosRef(
    val pokemonId: Int,
    val moveId: Int
)
