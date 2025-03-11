package com.nvegas.domain.usecases

fun interface SignOutUseCase {
    suspend fun invoke():Boolean
}