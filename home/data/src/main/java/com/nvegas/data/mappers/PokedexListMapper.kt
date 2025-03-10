package com.nvegas.data.mappers

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