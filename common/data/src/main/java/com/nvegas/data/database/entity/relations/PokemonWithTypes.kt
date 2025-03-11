package com.nvegas.data.database.entity.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.nvegas.data.database.entity.PokemonEntity
import com.nvegas.data.database.entity.PokemonTypeEntity

data class PokemonWithTypes(
    @Embedded val pokemon: PokemonEntity,
    @Relation(
        parentColumn = "pokemonId",
        entityColumn = "typeId",
        associateBy = Junction(PokemonTypeCrosRef::class)
    )
    val types: List<PokemonTypeEntity>
)
