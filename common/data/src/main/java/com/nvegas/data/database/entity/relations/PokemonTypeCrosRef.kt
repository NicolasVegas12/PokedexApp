package com.nvegas.data.database.entity.relations

import androidx.room.Entity

@Entity(primaryKeys = ["pokemonId", "typeId"])
data class PokemonTypeCrosRef(
    val pokemonId: Int,
    val typeId: Int
)
