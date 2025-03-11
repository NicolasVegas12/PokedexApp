package com.nvegas.presentation.explore.frame

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.nvegas.core.ui.text.TextComponent
import com.nvegas.domain.models.list.PokedexListResultModel

@Composable
fun PokemonDetailDialog(
    item: PokedexListResultModel
) {

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .background(MaterialTheme.colorScheme.surfaceContainerLowest)
    ) {


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {

                AsyncImage(
                    item.detail?.sprites?.artWork,
                    null,
                    modifier = Modifier.size(96.dp)
                )
                TextComponent(
                    item.name,
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                )
            }
            TextComponent(
                "Characteristics",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
            )
            TextComponent("Height: ${item.detail?.height}")
            TextComponent("Weight: ${item.detail?.weight}")
            TextComponent("Abilities: ${item.detail?.abilities?.joinToString { it.name }}")
            TextComponent("Types: ${item.detail?.types?.joinToString { it.name }}")
            TextComponent(
                "Moves",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
            )
            item.detail?.moves?.forEach {
                TextComponent(it.name)
            }

        }
    }
}

@Preview(name = "PokemonDetailDialog")
@Composable
private fun PreviewPokemonDetailDialog() {
    PokemonDetailDialog(PokedexListResultModel(name = "Bulbasaur"))
}