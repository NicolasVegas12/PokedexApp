package com.nvegas.navigation.ui.components

import com.nvegas.core.navigation.destinations.HomeDestination
import com.nvegas.navigation.R
import com.nvegas.core.R as CR

object BottomNavItemsProvider {
    val BOTTOM_NAV_ITEMS = listOf(
        BottomNavItem(
            name = "Explorar",
            icon = CR.drawable.baseline_search_24,
            route = HomeDestination.HomePrincipalRoute,
        ),
        BottomNavItem(
            name = "Equipo",
            icon = CR.drawable.ic_pokeball,
            route = HomeDestination.HomePokemonTeamRoute,
        ),

        BottomNavItem(
            name = "Perfil",
            icon = CR.drawable.baseline_person_outline_24,
            route = HomeDestination.HomeProfileRoute,
        ),
    )
}