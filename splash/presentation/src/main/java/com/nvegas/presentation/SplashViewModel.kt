package com.nvegas.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nvegas.common.navigation.components.Navigator
import com.nvegas.common.navigation.destinations.RootDestination
import com.nvegas.common.states.GenericScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

typealias SplashRedirectState = GenericScreenState<Boolean>

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val navigator: Navigator,
) : ViewModel() {

    private val _splashRedirectScreenState = MutableStateFlow(SplashRedirectState())
    val splashRedirectScreenState = _splashRedirectScreenState.onStart { loadData() }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000L),
        SplashRedirectState()
    )


    private suspend fun loadData() {
        _splashRedirectScreenState.value = SplashRedirectState(isLoading = true)
        try {
            delay(3000)
            navigateToAuth()
        } catch (e: Exception) {
            _splashRedirectScreenState.value = SplashRedirectState(error = e.message.toString())

        }

    }

    private suspend fun navigateToAuth() {
        navigator.updateStartDestination(RootDestination.HomeGraph)
        navigator.navigate(RootDestination.HomeGraph, navOptions = {
            popUpTo(navigator.startDestination) {
                inclusive = false
            }
        })
    }


}