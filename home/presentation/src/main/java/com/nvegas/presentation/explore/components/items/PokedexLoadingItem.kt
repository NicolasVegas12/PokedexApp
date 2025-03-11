package com.nvegas.presentation.explore.components.items

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun PokedexLoadingItem(
    height: Dp,
    width: Dp
) {
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
                .height(height)
                .width(width)
                .align(Alignment.CenterHorizontally),
            composition = composition,
            iterations = LottieConstants.IterateForever,
            contentScale = ContentScale.FillBounds
        )
    }
}

@Preview(name = "PokedexLoadingItem")
@Composable
private fun PreviewPokedexLoadingItem() {
    PokedexLoadingItem(103.dp, 103.dp)
}