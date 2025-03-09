package com.nvegas.common.navigation.destinations

import kotlinx.serialization.Serializable


sealed class SplashDestination : Destination {
    @Serializable
    data object SplashScreen : SplashDestination()

}