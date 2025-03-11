package com.nvegas.data.repository

import com.nvegas.data.database.dao.PokemonDao
import com.nvegas.data.database.entity.relations.PokemonAbilityCrosRef
import com.nvegas.data.database.entity.relations.PokemonMoveCrosRef
import com.nvegas.data.database.entity.relations.PokemonTypeCrosRef
import com.nvegas.data.mappers.toAbilityDatabase
import com.nvegas.data.mappers.toDatabase
import com.nvegas.data.mappers.toDomain
import com.nvegas.data.mappers.toMoveDatabase
import com.nvegas.data.mappers.toTypeDatabase
import com.nvegas.data.network.service.PokedexService
import com.nvegas.domain.models.detail.PokemonDetailModel
import com.nvegas.domain.models.list.PokedexListPagerModel
import com.nvegas.domain.models.list.PokedexListResultModel
import javax.inject.Inject

class PokedexRepositoryImpl @Inject constructor(
    private val api: PokedexService,
    private val pokemonDao: PokemonDao
) : PokedexRepository {
    override suspend fun getPokedexListFromApi(offset: Int, limit: Int): PokedexListPagerModel =
        api.getPokedexList(offset, limit).toDomain()

    override suspend fun getPokemonDetailFromApi(pokemonId: Int): PokemonDetailModel {
        val response = api.getPokemonDetail(pokemonId)
        return response.toDomain()
    }

    override suspend fun insertPokemon(pokemon: PokedexListResultModel) {
        val formatedPokemon = pokemon.toDatabase()
        val abilities = pokemon.toAbilityDatabase()
        val moves = pokemon.toMoveDatabase()
        val types = pokemon.toTypeDatabase()
        pokemonDao.insertPokemon(formatedPokemon)
        abilities.map {
            pokemonDao.insertAbility(it)
            pokemonDao.insertPokemonWithAbilities(
                PokemonAbilityCrosRef(
                    formatedPokemon.pokemonId,
                    it.abilityId
                )
            )
        }

        moves.map {
            pokemonDao.insertMove(it)
            pokemonDao.insertPokemonWithMoves(
                PokemonMoveCrosRef(
                    formatedPokemon.pokemonId,
                    it.moveId
                )
            )
        }
        types.map {
            pokemonDao.insertType(it)
            pokemonDao.insertPokemonWithTypes(
                PokemonTypeCrosRef(
                    formatedPokemon.pokemonId,
                    it.typeId
                )
            )
        }


    }

    override suspend fun getPokemonCount(): Int = pokemonDao.pokemonCount()

    override suspend fun getPokemons(start: Int, end: Int): List<PokedexListResultModel> {
        val pokemons = pokemonDao.getPokemonPager(start, end)
        val newList = pokemons.map { poke ->
            val abilities = pokemonDao.getPokemonWithAbilities(poke.pokemonId)
            val moves = pokemonDao.getPokemonWithMoves(poke.pokemonId)
            val types = pokemonDao.getPokemonWithTypes(poke.pokemonId)
            val pokemon = poke.toDomain()
            pokemon.copy(
                detail = pokemon.detail?.copy(
                    abilities = abilities.abilities.map { it.toDomain() },
                    moves = moves.moves.map { it.toDomain() },
                    types = types.types.map { it.toDomain() }
                )
            )
        }
        return newList
    }

}