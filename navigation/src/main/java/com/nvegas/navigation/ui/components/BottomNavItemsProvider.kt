package com.nvegas.navigation.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Explore
import androidx.compose.material.icons.outlined.PeopleOutline
import androidx.compose.material.icons.outlined.Person
import com.nvegas.common.navigation.destinations.HomeDestination

object BottomNavItemsProvider {
    val BOTTOM_NAV_ITEMS = listOf(
        BottomNavItem(
            name = "Explorar",
            icon = Icons.Outlined.Explore,
            route = HomeDestination.HomePrincipalRoute,
        ),
        BottomNavItem(
            name = "Equipo",
            icon = Icons.Outlined.PeopleOutline,
            route = HomeDestination.HomePokemonTeamRoute,
        ),

        BottomNavItem(
            name = "Perfil",
            icon = Icons.Outlined.Person,
            route = HomeDestination.HomeProfileRoute,
        ),
    )
}