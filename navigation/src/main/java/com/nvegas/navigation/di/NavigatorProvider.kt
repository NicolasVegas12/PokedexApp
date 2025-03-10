package com.nvegas.navigation.di

import com.nvegas.core.navigation.components.Navigator
import com.nvegas.core.navigation.destinations.RootDestination
import com.nvegas.navigation.components.NavigatorImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NavigatorProvider {

    @Provides
    @Singleton
    fun navigatorProvider(): Navigator =
        NavigatorImpl(initialDestination = RootDestination.SplashGraph)
}