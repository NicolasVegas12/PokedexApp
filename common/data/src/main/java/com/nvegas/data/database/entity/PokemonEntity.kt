package com.nvegas.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PokemonEntity(
    @PrimaryKey(autoGenerate = false) val pokemonId: Int = 0,
    val name: String = "",
    val url: String = "",
    val height: Int = 0,
    val weight: Int = 0,
    val defaultImage: String = "",
    val artWorkImage: String = "",



)
