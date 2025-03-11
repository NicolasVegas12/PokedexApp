package com.nvegas.presentation.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeProfileScreen(
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        Text(text = "HomeProfileScreen")
    }
}

@Preview(name = "HomeProfileScreen")
@Composable
private fun PreviewHomeProfileScreen() {
    HomeProfileScreen()
}