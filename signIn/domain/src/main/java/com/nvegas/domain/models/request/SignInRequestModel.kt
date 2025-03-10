package com.nvegas.domain.models.request

data class SignInRequestModel(
    val email:String = "",
    val emailError:String? = "",
    val password:String = "",
    val passwordError:String? = "",
)
