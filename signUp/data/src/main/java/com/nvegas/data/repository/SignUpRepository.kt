package com.nvegas.data.repository

import com.nvegas.domain.models.SignUpRequestModel

interface SignUpRepository {

    suspend fun signUp(request: SignUpRequestModel): Boolean
}