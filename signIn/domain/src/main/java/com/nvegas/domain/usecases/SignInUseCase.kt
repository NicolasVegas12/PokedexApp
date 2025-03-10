package com.nvegas.domain.usecases

import com.nvegas.domain.models.request.SignInRequestModel

fun interface SignInUseCase {
    suspend fun invoke(request: SignInRequestModel): Boolean
}