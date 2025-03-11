package com.nvegas.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PokemonAbilityEntity(
    @PrimaryKey val abilityId: Int = 0,
    val name: String = "",
    val isHidden: Boolean = false,
    val slot: Int = 0
)
