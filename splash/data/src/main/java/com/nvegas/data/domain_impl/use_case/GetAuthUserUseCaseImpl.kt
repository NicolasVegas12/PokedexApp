package com.nvegas.data.domain_impl.use_case

import com.nvegas.data.repository.SplashRepository
import com.nvegas.domain.usecases.GetAuthUserUseCase
import javax.inject.Inject

class GetAuthUserUseCaseImpl @Inject constructor(
    private val repository: SplashRepository,
) : GetAuthUserUseCase {
    override fun invoke(): Boolean {
        return repository.getAuthUser()
    }
}