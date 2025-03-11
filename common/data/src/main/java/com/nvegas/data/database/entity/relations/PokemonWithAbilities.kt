package com.nvegas.data.database.entity.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.nvegas.data.database.entity.PokemonAbilityEntity
import com.nvegas.data.database.entity.PokemonEntity

data class PokemonWithAbilities(
    @Embedded val pokemon: PokemonEntity,
    @Relation(
        parentColumn = "pokemonId",
        entityColumn = "abilityId",
        associateBy = Junction(PokemonAbilityCrosRef::class)
    )
    val abilities: List<PokemonAbilityEntity>

)
