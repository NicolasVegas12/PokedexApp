package com.nvegas.presentation

sealed class SignInInputTypes {
    data object Email : SignInInputTypes()
    data object Password : SignInInputTypes()
}