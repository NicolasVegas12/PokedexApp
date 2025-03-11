package com.nvegas.data.database.entity.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.nvegas.data.database.entity.PokemonEntity
import com.nvegas.data.database.entity.PokemonMoveEntity

data class PokemonWithMoves(
    @Embedded val pokemon: PokemonEntity,
    @Relation(
        parentColumn = "pokemonId",
        entityColumn = "moveId",
        associateBy = Junction(PokemonMoveCrosRef::class)
    )
    val moves: List<PokemonMoveEntity>
)
