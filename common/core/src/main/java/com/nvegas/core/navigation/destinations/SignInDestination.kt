package com.nvegas.core.navigation.destinations

import kotlinx.serialization.Serializable

sealed class SignInDestination: Destination {

    @Serializable
    data object SignInRoute : SignInDestination()
}