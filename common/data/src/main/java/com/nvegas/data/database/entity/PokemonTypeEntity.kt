package com.nvegas.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PokemonTypeEntity(
    @PrimaryKey val typeId: Int = 0,
    val slot:Int = 0,
    val name: String = "",
    val url: String = ""
)
