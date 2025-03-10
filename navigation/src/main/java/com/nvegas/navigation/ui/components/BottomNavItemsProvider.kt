package com.nvegas.navigation.ui.components

import com.nvegas.common.navigation.destinations.HomeDestination
import com.nvegas.navigation.R

object BottomNavItemsProvider {
    val BOTTOM_NAV_ITEMS = listOf(
        BottomNavItem(
            name = "Explorar",
            icon = R.drawable.baseline_search_24,
            route = HomeDestination.HomePrincipalRoute,
        ),
        BottomNavItem(
            name = "Equipo",
            icon = R.drawable.ic_pokeball,
            route = HomeDestination.HomePokemonTeamRoute,
        ),

        BottomNavItem(
            name = "Perfil",
            icon = R.drawable.baseline_person_outline_24,
            route = HomeDestination.HomeProfileRoute,
        ),
    )
}