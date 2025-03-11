package com.nvegas.presentation.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nvegas.core.ui.buttons.ButtonComponent

@Composable
fun HomeProfileScreen(
    signOut: () -> Unit
) {
    Box(Modifier.fillMaxSize().padding(16.dp), contentAlignment = Alignment.Center) {
        ButtonComponent("Sign Out") {signOut() }
    }
}

@Preview(name = "HomeProfileScreen")
@Composable
private fun PreviewHomeProfileScreen() {
    HomeProfileScreen({})
}