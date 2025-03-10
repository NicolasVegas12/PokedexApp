package com.nvegas.data.domain_impl.use_case

import com.nvegas.common.utils.IODispatcher
import com.nvegas.data.repository.SignUpRepository
import com.nvegas.domain.models.SignUpRequestModel
import com.nvegas.domain.usecases.SignUpUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SignUpUseCaseImpl @Inject constructor(
    private val repository: SignUpRepository,
    @IODispatcher private val dispatcher: CoroutineDispatcher
):SignUpUseCase {

   override suspend fun invoke(request: SignUpRequestModel): Boolean = withContext(dispatcher) {
        val response = repository.signUp(request)
        return@withContext response
    }
}