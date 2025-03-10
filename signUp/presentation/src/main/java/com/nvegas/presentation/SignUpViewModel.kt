package com.nvegas.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.core.util.PatternsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nvegas.core.navigation.components.Navigator
import com.nvegas.core.navigation.destinations.RootDestination
import com.nvegas.core.states.GenericScreenState
import com.nvegas.domain.models.SignUpRequestModel
import com.nvegas.domain.usecases.SignUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


typealias SignUpState = GenericScreenState<Boolean>

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val navigator: Navigator,
    private val signUpUseCase: SignUpUseCase
) : ViewModel() {


    private val _state = mutableStateOf(SignUpState())
    val state: State<SignUpState> = _state


    private val _currentRequest = mutableStateOf(SignUpRequestModel())
    val currentRequest: State<SignUpRequestModel> = _currentRequest


    fun setRequest(request: SignUpRequestModel, type: SignUpInputType) {
        _currentRequest.value = request
        when (type) {
            is SignUpInputType.Email -> validateEmail(request.email)
            is SignUpInputType.Password -> validatePassword(request.password)
        }
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

    fun goBack() = viewModelScope.launch {
        navigator.navigateUp()
    }

    private suspend fun navigateToHome() {
        navigator.updateStartDestination(RootDestination.HomeGraph)
        navigator.navigate(RootDestination.HomeGraph, navOptions = {
            popUpTo(navigator.startDestination) {
                inclusive = false
            }
        })
    }

    fun signUp() = viewModelScope.launch {
        _state.value = SignUpState(isLoading = true)
        try {
            val response = signUpUseCase.invoke(_currentRequest.value)

            if (response) {
                navigateToHome()
            } else {
                _state.value =
                    SignUpState(error = "An error occurred while signing in. Please check your credentials.")
            }

        } catch (e: Exception) {
            e.printStackTrace()
            _state.value = SignUpState(error = e.message.toString())
        }
    }

    fun resetState() {
        _state.value = SignUpState()
    }
}