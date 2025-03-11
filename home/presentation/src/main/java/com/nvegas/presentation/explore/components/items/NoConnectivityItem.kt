package com.nvegas.presentation.explore.components.items

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.WifiOff
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.nvegas.core.ui.text.TextComponent

@Composable
fun NoConnectivityItem(
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        TextComponent(
            "No Internet Connection",
            modifier = Modifier.weight(1f),
            alignment = TextAlign.Center
        )
        Icon(Icons.Outlined.WifiOff, null, tint = MaterialTheme.colorScheme.onBackground)
    }
}

@Preview(name = "NoConnectivityItem")
@Composable
private fun PreviewNoConnectivityItem() {
    NoConnectivityItem()
}