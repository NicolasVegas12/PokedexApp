package com.nvegas.domain.models

data class SignUpRequestModel(
    val email: String = "",
    val password: String = "",
    val emailError: String? = null,
    val passwordError: String? = null
)
