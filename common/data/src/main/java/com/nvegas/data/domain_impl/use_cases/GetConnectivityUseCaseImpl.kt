package com.nvegas.data.domain_impl.use_cases

import com.nvegas.data.repository.app.AppRepository
import com.nvegas.domain.usecases.GetConnectivityUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetConnectivityUseCaseImpl @Inject constructor(
    private val repository: AppRepository
) : GetConnectivityUseCase {
    override fun invoke(): Flow<Boolean> = repository.isInternetAvailable()

}