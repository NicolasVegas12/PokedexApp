package com.nvegas.presentation.team

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeTeamScreen(
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        Text(text = "HomeTeamScreen")
    }
}

@Preview(name = "HomeTeamScreen")
@Composable
private fun PreviewHomeTeamScreen() {
    HomeTeamScreen()
}