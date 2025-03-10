package com.nvegas.core.navigation.destinations

import kotlinx.serialization.Serializable


sealed class SplashDestination : Destination {
    @Serializable
    data object SplashScreen : SplashDestination()

}