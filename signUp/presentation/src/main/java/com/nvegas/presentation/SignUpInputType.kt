package com.nvegas.presentation

sealed class SignUpInputType {
    object Email : SignUpInputType()
    object Password : SignUpInputType()

}