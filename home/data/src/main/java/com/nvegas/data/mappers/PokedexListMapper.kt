package com.nvegas.data.mappers

import com.nvegas.data.database.entity.PokemonAbilityEntity
import com.nvegas.data.database.entity.PokemonEntity
import com.nvegas.data.database.entity.PokemonMoveEntity
import com.nvegas.data.network.dto.response.detail.PokemonAbilityResponse
import com.nvegas.data.network.dto.response.detail.PokemonDetailResponse
import com.nvegas.data.network.dto.response.detail.PokemonMoveResponse
import com.nvegas.data.network.dto.response.detail.PokemonSpritesResponse
import com.nvegas.data.network.dto.response.list.PokedexListPagerResponse
import com.nvegas.data.network.dto.response.list.PokedexListResultResponse
import com.nvegas.domain.models.detail.PokemonAbilityModel
import com.nvegas.domain.models.detail.PokemonDetailModel
import com.nvegas.domain.models.detail.PokemonMoveModel
import com.nvegas.domain.models.detail.PokemonSpritesModel
import com.nvegas.domain.models.list.PokedexListPagerModel
import com.nvegas.domain.models.list.PokedexListResultModel

fun PokedexListPagerResponse.toDomain() = PokedexListPagerModel(
    count = count,
    next = next,
    previous = previous,
    results = results.map { it.toDomain() }
)

fun PokedexListResultResponse.toDomain(): PokedexListResultModel {
    val id = url.split("/".toRegex()).dropLast(1).last()
    return PokedexListResultModel(
        id = id.toInt(),
        name = name,
        url = url
    )
}

fun PokemonDetailResponse.toDomain() = PokemonDetailModel(
    id = id,
    name = name,
    height = height,
    weight = weight,
    sprites = sprites.toDomain(),
    abilities = abilities.map { it.toDomain() },
    moves = moves.map { it.toDomain() }
)

fun PokemonSpritesResponse.toDomain() = PokemonSpritesModel(
    frontDefault = frontDefault,
    artWork = other.officialArtwork.frontDefault
)

fun PokemonAbilityResponse.toDomain(): PokemonAbilityModel {
    val id = ability.url.split("/".toRegex()).dropLast(1).last()
    return PokemonAbilityModel(
        id = id.toInt(),
        name = ability.name,
        isHidden = isHidden,
        slot = slot,
    )
}

fun PokemonMoveResponse.toDomain(): PokemonMoveModel {
    val id = move.url.split("/".toRegex()).dropLast(1).last()
    return PokemonMoveModel(
        id = id.toInt(),
        name = move.name

    )
}

fun PokedexListResultModel.toDatabase(): PokemonEntity {
    val pokemon = PokemonEntity(
        pokemonId = id,
        name = name,
        url = url,
        height = detail?.height ?: 0,
        weight = detail?.weight ?: 0,
        defaultImage = detail?.sprites?.frontDefault ?: "",
        artWorkImage = detail?.sprites?.artWork ?: ""
    )



    return pokemon
}

fun PokedexListResultModel.toAbilityDatabase(): List<PokemonAbilityEntity> {
    val abilities: List<PokemonAbilityEntity> = detail?.abilities?.map {
        PokemonAbilityEntity(
            abilityId = it.id,
            name = it.name,
            isHidden = it.isHidden,
            slot = it.slot
        )
    } ?: emptyList()
    return abilities
}

fun PokedexListResultModel.toMoveDatabase(): List<PokemonMoveEntity> {
    val moves = detail?.moves?.map {
        PokemonMoveEntity(
            moveId = it.id,
            name = it.name
        )
    } ?: emptyList()
    return moves
}

fun PokemonEntity.toDomain() = PokedexListResultModel(
    id = pokemonId,
    name = name,
    url = url,
    detail = PokemonDetailModel(
        id = pokemonId,
        name = name,
        height = height,
        weight = weight,
        sprites = PokemonSpritesModel(
            frontDefault = defaultImage,
            artWork = artWorkImage

        ),
        moves = emptyList(),
        abilities = emptyList()
    )
)

fun PokemonAbilityEntity.toDomain() = PokemonAbilityModel(
    id = abilityId,
    name = name, isHidden = isHidden, slot = slot
)
fun PokemonMoveEntity.toDomain() = PokemonMoveModel(
    id = moveId,
    name = name
)