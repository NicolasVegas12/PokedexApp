package com.nvegas.navigation.ui.components

import com.nvegas.common.navigation.destinations.Destination

data class BottomNavItem(
    val name: String,
    val route: Destination,
    val icon: Int,
)
