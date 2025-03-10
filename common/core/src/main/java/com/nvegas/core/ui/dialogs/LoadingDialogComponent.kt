package com.nvegas.core.ui.dialogs

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.nvegas.core.R
import com.nvegas.core.theme.AppTheme

@Composable
fun LoadingDialogComponent(
) {
    Dialog(
        onDismissRequest = { },
        properties = DialogProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = false
        ),

        ) {
        Box(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(10.dp)
                )
                .background(MaterialTheme.colorScheme.surfaceContainerLowest)


        ) {
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
                    .height(103.dp)
                    .width(103.dp)
                    .align(Alignment.Center)
                    .padding(5.dp),
                composition = composition,
                iterations = LottieConstants.IterateForever,
                contentScale = ContentScale.FillBounds
            )
        }

    }
}

@Preview(name = "Light Mode")
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewLoadingDialogComponent() {
    AppTheme {
        LoadingDialogComponent()
    }
}