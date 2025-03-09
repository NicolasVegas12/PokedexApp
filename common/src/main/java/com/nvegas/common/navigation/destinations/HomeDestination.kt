package com.nvegas.common.navigation.destinations

import kotlinx.serialization.Serializable

sealed class HomeDestination : Destination {
    @Serializable
    data object HomePrincipalRoute : HomeDestination()
    @Serializable
    data object HomePokemonTeamRoute: HomeDestination()
    @Serializable
    data object HomeProfileRoute : HomeDestination()

}