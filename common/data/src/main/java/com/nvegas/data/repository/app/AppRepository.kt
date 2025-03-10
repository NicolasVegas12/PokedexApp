package com.nvegas.data.repository.app

import kotlinx.coroutines.flow.Flow

interface AppRepository {
    fun isInternetAvailable(): Flow<Boolean>
}