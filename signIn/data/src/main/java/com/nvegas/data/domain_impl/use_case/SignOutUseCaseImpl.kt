package com.nvegas.data.domain_impl.use_case

import com.nvegas.data.repository.SignInRepository
import com.nvegas.domain.usecases.SignOutUseCase
import javax.inject.Inject

class SignOutUseCaseImpl @Inject constructor(
    private val repository: SignInRepository
) : SignOutUseCase {
    override suspend fun invoke(): Boolean = repository.signOut()
}