package com.nvegas.domain.usecases

import kotlinx.coroutines.flow.Flow

fun interface GetConnectivityUseCase {
    fun invoke(): Flow<Boolean>
}