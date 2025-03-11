package com.nvegas.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.nvegas.data.database.entity.PokemonAbilityEntity
import com.nvegas.data.database.entity.PokemonEntity
import com.nvegas.data.database.entity.PokemonMoveEntity
import com.nvegas.data.database.entity.PokemonTypeEntity
import com.nvegas.data.database.entity.relations.PokemonAbilityCrosRef
import com.nvegas.data.database.entity.relations.PokemonMoveCrosRef
import com.nvegas.data.database.entity.relations.PokemonTypeCrosRef
import com.nvegas.data.database.entity.relations.PokemonWithAbilities
import com.nvegas.data.database.entity.relations.PokemonWithMoves
import com.nvegas.data.database.entity.relations.PokemonWithTypes

@Dao
interface PokemonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemon(pokemon: PokemonEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAbility(pokemon: PokemonAbilityEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertType(pokemon: PokemonTypeEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemonWithTypes(crossRef: PokemonTypeCrosRef)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMove(pokemon: PokemonMoveEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemonWithAbilities(crossRef: PokemonAbilityCrosRef)

    @Query("SELECT COUNT(*) FROM PokemonEntity")
    suspend fun pokemonCount(): Int

    @Query("SELECT * FROM PokemonEntity where pokemonId between :start and :end")
    suspend fun getPokemonPager(start:Int, end:Int): List<PokemonEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemonWithMoves(crossRef: PokemonMoveCrosRef)

    @Transaction
    @Query("SELECT * FROM PokemonEntity where pokemonId = :pokemonId")
    suspend fun getPokemonWithAbilities(pokemonId: Int): PokemonWithAbilities

    @Transaction
    @Query("SELECT * FROM PokemonEntity where pokemonId = :pokemonId")
    suspend fun getPokemonWithMoves(pokemonId: Int): PokemonWithMoves

    @Transaction
    @Query("SELECT * FROM PokemonEntity where pokemonId = :pokemonId")
    suspend fun getPokemonWithTypes(pokemonId: Int): PokemonWithTypes


}