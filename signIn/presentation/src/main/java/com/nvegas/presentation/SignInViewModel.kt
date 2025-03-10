package com.nvegas.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.core.util.PatternsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nvegas.core.navigation.destinations.RootDestination
import com.nvegas.core.navigation.components.Navigator
import com.nvegas.core.states.GenericScreenState
import com.nvegas.domain.models.request.SignInRequestModel
import com.nvegas.domain.usecases.SignInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


typealias SignInState = GenericScreenState<Boolean>

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val navigator: Navigator,
    private val signInUseCase: SignInUseCase
) : ViewModel() {

    private val _currentRequest = mutableStateOf(SignInRequestModel())
    val currentRequest: State<SignInRequestModel> = _currentRequest

    private val _state = mutableStateOf(SignInState())
    val state: State<SignInState> = _state


    fun setRequest(request: SignInRequestModel, type: SignInInputTypes) {
        _currentRequest.value = request
        when (type) {
            is SignInInputTypes.Email -> validateEmail(request.email)
            is SignInInputTypes.Password -> validatePassword(request.password)
        }
    }

    fun navigateToSignUp() = viewModelScope.launch {
        navigator.navigate(RootDestination.SignUpGraph)
    }

    private suspend fun navigateToHome() {
        navigator.updateStartDestination(RootDestination.HomeGraph)
        navigator.navigate(RootDestination.HomeGraph, navOptions = {
            popUpTo(navigator.startDestination) {
                inclusive = false
            }
        })
    }

    private fun validateEmail(text: String) {
        when {
            text.isEmpty() -> _currentRequest.value =
                _currentRequest.value.copy(emailError = "Email is required")

            !text.matches(PatternsCompat.EMAIL_ADDRESS.toRegex()) -> _currentRequest.value =
                _currentRequest.value.copy(emailError = "Email is invalid")

            else -> _currentRequest.value = _currentRequest.value.copy(emailError = null)
        }
    }

    private fun validatePassword(text: String) {
        when {
            text.isEmpty() -> _currentRequest.value =
                _currentRequest.value.copy(passwordError = "Password is required")

            text.length < 6 -> _currentRequest.value =
                _currentRequest.value.copy(passwordError = "Password must be at least 6 characters")

            else -> _currentRequest.value = _currentRequest.value.copy(passwordError = null)
        }
    }

    fun signIn() = viewModelScope.launch {
        _state.value = SignInState(isLoading = true)
        try {
            val response = signInUseCase.invoke(_currentRequest.value)
            _state.value = SignInState(response = response)

            if (response) {
                navigateToHome()
            } else {
                _state.value =
                    SignInState(error = "An error occurred while signing in. Please check your credentials.")
            }
        } catch (e: Exception) {
            e.printStackTrace()
            _state.value = SignInState(error = e.message.toString())
        }
    }

    fun resetState() {
        _state.value = SignInState()
    }
}