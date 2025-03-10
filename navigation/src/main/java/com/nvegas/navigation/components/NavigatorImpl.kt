package com.nvegas.navigation.components

import androidx.compose.runtime.mutableStateOf
import androidx.navigation.NavOptionsBuilder
import com.nvegas.core.navigation.components.NavigationAction
import com.nvegas.core.navigation.components.Navigator
import com.nvegas.core.navigation.destinations.Destination
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class NavigatorImpl(
    initialDestination: Destination
) : Navigator {
    private val _startDestination = mutableStateOf(initialDestination)
    override val startDestination: Destination
        get() = _startDestination.value

    private val _navigationActions = MutableSharedFlow<NavigationAction>(
        replay = 1,
        extraBufferCapacity = 1
    )
    override val navigationActions = _navigationActions.asSharedFlow()

    override suspend fun updateStartDestination(newDestination: Destination) {
        _startDestination.value = newDestination
        _navigationActions.emit(NavigationAction.UpdateStartDestination(newDestination))
    }

    override suspend fun navigate(
        destination: Destination,
        navOptions: NavOptionsBuilder.() -> Unit
    ) {
        _navigationActions.emit(
            NavigationAction.Navigate(
                destination = destination,
                navOptions = navOptions
            )
        )
    }

    override suspend fun navigateUp() {
        _navigationActions.emit(NavigationAction.NavigateUp)
    }


}