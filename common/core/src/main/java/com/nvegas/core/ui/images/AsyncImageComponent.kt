package com.nvegas.core.ui.images

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.nvegas.core.R
import com.nvegas.core.theme.AppTheme

@Composable
fun AsyncImageComponent(
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .build()
    )

    val state = painter.state
    LaunchedEffect(state) {
        Log.d("AsyncImageComponent", "Estado de imagen: $state")
    }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        when (state) {
            is AsyncImagePainter.State.Loading -> {
                val isNightMode = isSystemInDarkTheme()
                val composition by rememberLottieComposition(
                    LottieCompositionSpec.RawRes(
                        if (isNightMode) {
                            R.raw.loading_animation_white
                        } else {
                            R.raw.loading_animation_black
                        }
                    )
                )

                LottieAnimation(
                    modifier = Modifier
                        .height(32.dp)
                        .width(32.dp)
                        .align(Alignment.Center),
                    composition = composition,
                    iterations = LottieConstants.IterateForever,
                    contentScale = ContentScale.FillBounds
                )
            }

            is AsyncImagePainter.State.Error -> {
                Icon(
                    painter = painterResource(id = R.drawable.ic_pokeball), // Reemplázalo con tu ícono de error
                    contentDescription = "Error al cargar imagen",
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }

            else -> {
                Image(
                    painter = painter,
                    contentDescription = "Imagen cargada",
                    modifier = Modifier.size(96.dp)
                )
            }
        }
    }
}

@Preview(name = "AsyncImageComponent")
@Preview(name = "AsyncImageComponentDark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewAsyncImageComponent() {
    AppTheme {

        AsyncImageComponent("", modifier = Modifier.size(96.dp))
    }
}