package com.nvegas.presentation.explore

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SearchBar
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.nvegas.core.theme.AppTheme
import com.nvegas.core.ui.text.TextComponent
import com.nvegas.domain.models.list.PokedexListResultModel
import com.nvegas.presentation.explore.components.items.PokedexLoadingItem
import com.nvegas.presentation.explore.components.items.PokemonListItem
import com.nvegas.presentation.explore.frame.PokemonDetailDialog
import kotlinx.coroutines.flow.MutableStateFlow

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun HomeExploreScreen(
    pokedex: LazyPagingItems<PokedexListResultModel>?,
    searchQuery: String,
    setSeachQuery: (String) -> Unit
) {
    var selectedItem: PokedexListResultModel? by remember { mutableStateOf(null) }
    var detailVisibility by remember { mutableStateOf(false) }

    val detailState = rememberModalBottomSheetState()
    var isSearchActive by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            item {
                TextComponent("Pokedex", style = MaterialTheme.typography.titleLarge)
            }

            item {
                SearchBar(
                    query = searchQuery,
                    onQueryChange = setSeachQuery,
                    onSearch = { isSearchActive = false },
                    active = false,
                    onActiveChange = { isSearchActive = it },
                    placeholder = { TextComponent("Buscar Pokémon...") },
                    modifier = Modifier.fillMaxWidth(),
                    windowInsets = WindowInsets(0.dp, 0.dp, 0.dp, 0.dp)
                ) {
                    // No mostramos nada dentro del SearchBar
                }
            }

            pokedex?.let {
                item {
                    val context = LocalContext.current
                    LaunchedEffect(key1 = pokedex.loadState) {
                        if (pokedex.loadState.refresh is LoadState.Error) {
                            Toast.makeText(
                                context,
                                "Error: " + (pokedex.loadState.refresh as LoadState.Error).error.message,
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }

                if (pokedex.loadState.refresh is LoadState.Loading) {
                    item {
                        PokedexLoadingItem(103.dp, 103.dp)
                    }
                } else {

                    items(pokedex.itemCount) {
                        pokedex[it]?.let {
                            PokemonListItem(it) {
                                selectedItem = it
                                detailVisibility = true
                            }
                        }

                    }
                    if (pokedex.loadState.append is LoadState.Loading) {
                        item {
                            PokedexLoadingItem(80.dp, 80.dp)
                        }
                    }

                }
                item {
                    Spacer(Modifier.height(60.dp))
                }
            }
        }
    }

    AnimatedVisibility(detailVisibility) {
        selectedItem?.let {
            ModalBottomSheet(
                onDismissRequest = { detailVisibility = false },
                sheetState = detailState,
                modifier = Modifier
                    .fillMaxWidth(),
                containerColor = MaterialTheme.colorScheme.surfaceContainerLowest,
                scrimColor = MaterialTheme.colorScheme.onBackground.copy(0.3f)
            ) {
                PokemonDetailDialog(it)
            }

        }
    }
}

@Preview(name = "Light Mode")
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewHomeExploreScreen() {
    val data = emptyList<PokedexListResultModel>()
    val flow = MutableStateFlow(PagingData.from(data))
    AppTheme {
        HomeExploreScreen(flow.collectAsLazyPagingItems(), "", {})
    }
}