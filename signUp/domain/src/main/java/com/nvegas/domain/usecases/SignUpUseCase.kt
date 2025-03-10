package com.nvegas.domain.usecases

import com.nvegas.domain.models.SignUpRequestModel

fun interface SignUpUseCase {
    suspend fun invoke(request: SignUpRequestModel): Boolean
}