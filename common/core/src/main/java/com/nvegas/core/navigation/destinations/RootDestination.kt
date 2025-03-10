package com.nvegas.core.navigation.destinations

import kotlinx.serialization.Serializable


sealed class RootDestination : Destination {

    @Serializable
    data object HomeGraph : RootDestination()
    @Serializable
    data object SplashGraph : RootDestination()

    @Serializable
    data object SignInGraph : RootDestination()

    @Serializable
    data object SignUpGraph : RootDestination()
}