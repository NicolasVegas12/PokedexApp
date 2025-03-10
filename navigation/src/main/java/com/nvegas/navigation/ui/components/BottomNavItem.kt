package com.nvegas.navigation.ui.components

import com.nvegas.core.navigation.destinations.Destination

data class BottomNavItem(
    val name: String,
    val route: Destination,
    val icon: Int,
)
