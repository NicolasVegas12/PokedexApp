package com.nvegas.data.database.entity.relations

import androidx.room.Entity

@Entity(primaryKeys = ["pokemonId", "abilityId"])
data class PokemonAbilityCrosRef(
    val pokemonId: Int,
    val abilityId: Int
)
