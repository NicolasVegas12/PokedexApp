package com.nvegas.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nvegas.data.database.dao.PokemonDao
import com.nvegas.data.database.entity.PokemonAbilityEntity
import com.nvegas.data.database.entity.PokemonEntity
import com.nvegas.data.database.entity.PokemonMoveEntity
import com.nvegas.data.database.entity.relations.PokemonAbilityCrosRef
import com.nvegas.data.database.entity.relations.PokemonMoveCrosRef

@Database(
    entities = [PokemonEntity::class,PokemonAbilityEntity::class,PokemonMoveEntity::class,PokemonAbilityCrosRef::class, PokemonMoveCrosRef::class],
    version = 1
)
abstract class PokedexDatabase : RoomDatabase() {
    abstract fun getPokemonDao(): PokemonDao
}