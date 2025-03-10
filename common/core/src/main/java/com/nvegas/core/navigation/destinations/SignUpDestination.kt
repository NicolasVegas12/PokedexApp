package com.nvegas.core.navigation.destinations

import kotlinx.serialization.Serializable

sealed class SignUpDestination: Destination {
    @Serializable
    data object SignUpRoute : SignUpDestination()

}