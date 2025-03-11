package com.nvegas.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nvegas.core.navigation.components.Navigator
import com.nvegas.core.navigation.destinations.RootDestination
import com.nvegas.domain.usecases.SignOutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeProfileViewModel @Inject constructor(
    private val navigator: Navigator,
    private val signOutUseCase: SignOutUseCase
):ViewModel() {

    fun signOut() = viewModelScope.launch{
        val result = signOutUseCase.invoke()
        if(result){
            navigateToSplash()
        }

    }

    fun navigateToSplash() = viewModelScope.launch {
        navigator.updateStartDestination(RootDestination.SplashGraph)
        navigator.navigate(RootDestination.SplashGraph, navOptions = {
            popUpTo(navigator.startDestination) {
                inclusive = false
            }
        })

    }
}