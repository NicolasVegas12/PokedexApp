package com.nvegas.navigation.ui.components

import androidx.compose.ui.graphics.vector.ImageVector
import com.nvegas.common.navigation.destinations.Destination

data class BottomNavItem(
    val name: String,
    val route: Destination,
    val icon: ImageVector,
)
