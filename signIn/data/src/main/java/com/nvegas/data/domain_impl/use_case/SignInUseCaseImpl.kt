package com.nvegas.data.domain_impl.use_case

import com.nvegas.common.utils.IODispatcher
import com.nvegas.data.repository.SignInRepository
import com.nvegas.domain.models.request.SignInRequestModel
import com.nvegas.domain.usecases.SignInUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SignInUseCaseImpl @Inject constructor(
    private val repository: SignInRepository,
    @IODispatcher private val dispatcher: CoroutineDispatcher
) :SignInUseCase{

   override suspend fun invoke(request: SignInRequestModel): Boolean = withContext(dispatcher) {
        val response = repository.signIn(request)
        return@withContext response
    }
}