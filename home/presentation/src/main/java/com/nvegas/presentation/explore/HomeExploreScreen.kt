package com.nvegas.presentation.explore

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.nvegas.core.theme.AppTheme
import com.nvegas.core.ui.text.TextComponent
import com.nvegas.domain.models.list.PokedexListResultModel
import com.nvegas.presentation.explore.components.items.PokemonListItem
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun HomeExploreScreen(
    pokedex: LazyPagingItems<PokedexListResultModel>?
) {
    Box(modifier = Modifier.fillMaxSize()) {

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            item {
                TextComponent("Pokedex", style = MaterialTheme.typography.titleLarge)
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
                        val isNightMode = isSystemInDarkTheme()
                        val composition by rememberLottieComposition(
                            LottieCompositionSpec.RawRes(
                                if (isNightMode) {
                                    com.nvegas.core.R.raw.loading_animation_white
                                } else {
                                    com.nvegas.core.R.raw.loading_animation_black
                                }
                            )
                        )
                        Column(modifier = Modifier.fillMaxWidth()) {
                            LottieAnimation(
                                modifier = Modifier
                                    .height(103.dp)
                                    .width(103.dp)
                                    .align(Alignment.CenterHorizontally),
                                composition = composition,
                                iterations = LottieConstants.IterateForever,
                                contentScale = ContentScale.FillBounds
                            )
                        }


                    }
                } else {
                    items(pokedex.itemCount) {
                        pokedex[it]?.let {
                            PokemonListItem(it)
                        }

                    }
                    if (pokedex.loadState.append is LoadState.Loading) {
                        item {
                            val isNightMode = isSystemInDarkTheme()
                            val composition by rememberLottieComposition(
                                LottieCompositionSpec.RawRes(
                                    if (isNightMode) {
                                        com.nvegas.core.R.raw.loading_animation_white
                                    } else {
                                        com.nvegas.core.R.raw.loading_animation_black
                                    }
                                )
                            )
                            Column(modifier = Modifier.fillMaxWidth()) {
                                LottieAnimation(
                                    modifier = Modifier
                                        .height(80.dp) // Un poco más pequeño para diferenciarlo del inicial
                                        .width(80.dp)
                                        .align(Alignment.CenterHorizontally),
                                    composition = composition,
                                    iterations = LottieConstants.IterateForever,
                                    contentScale = ContentScale.FillBounds
                                )
                            }
                        }
                    }

                }
                item {
                    Spacer(Modifier.height(60.dp))
                }

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
        HomeExploreScreen(flow.collectAsLazyPagingItems())
    }
}