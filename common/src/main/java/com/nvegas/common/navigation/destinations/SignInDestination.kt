package com.nvegas.common.navigation.destinations

import kotlinx.serialization.Serializable

sealed class SignInDestination:Destination {

    @Serializable
    data object SignInRoute : SignInDestination()
}