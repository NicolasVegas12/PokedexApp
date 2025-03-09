package com.nvegas.navigation.ui.root

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nvegas.common.navigation.components.Navigator
import com.nvegas.common.navigation.destinations.Destination
import com.nvegas.common.navigation.destinations.RootDestination
import com.nvegas.common.navigation.components.NavigationAction
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RootViewModel @Inject constructor(
    private val navigator: Navigator
) : ViewModel() {

    val navigationActions: Flow<NavigationAction> = navigator.navigationActions
    val startDestination = navigator.startDestination

    fun bottomBarNavigation(nextRoute: Destination) {
        viewModelScope.launch {
            navigator.navigate(destination = nextRoute,
                navOptions = {
                    popUpTo(RootDestination.HomeGraph) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                })
        }
    }
}