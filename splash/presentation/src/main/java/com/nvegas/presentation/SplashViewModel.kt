package com.nvegas.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nvegas.core.navigation.components.Navigator
import com.nvegas.core.navigation.destinations.RootDestination
import com.nvegas.core.states.GenericScreenState
import com.nvegas.domain.usecases.GetAuthUserUseCase
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
    private val getAuthUserUseCase: GetAuthUserUseCase
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
            val response = getAuthUserUseCase.invoke()
            delay(3000)
            if (response) {
                navigateToHome()
            } else {
                navigateToAuth()
            }
        } catch (e: Exception) {
            _splashRedirectScreenState.value = SplashRedirectState(error = e.message.toString())

        }

    }

    private suspend fun navigateToAuth() {
        navigator.updateStartDestination(RootDestination.SignInGraph)
        navigator.navigate(RootDestination.SignInGraph, navOptions = {
            popUpTo(navigator.startDestination) {
                inclusive = false
            }
        })
    }

    private suspend fun navigateToHome() {
        navigator.updateStartDestination(RootDestination.HomeGraph)
        navigator.navigate(RootDestination.HomeGraph, navOptions = {
            popUpTo(navigator.startDestination) {
                inclusive = false
            }
        })
    }


}