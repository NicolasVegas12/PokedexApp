package com.nvegas.data.repository

import com.nvegas.domain.models.request.SignInRequestModel

interface SignInRepository {
    suspend fun signIn(request: SignInRequestModel): Boolean
}