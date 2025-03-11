package com.nvegas.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PokemonMoveEntity(
    @PrimaryKey val moveId: Int = 0,
    val name: String = "",
)
