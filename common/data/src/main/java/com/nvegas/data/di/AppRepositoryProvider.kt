package com.nvegas.data.di

import android.content.Context
import com.nvegas.data.repository.app.AppRepository
import com.nvegas.data.repository.app.AppRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppRepositoryProvider {
    @Provides
    @Singleton
    fun providePokedexRepository(@ApplicationContext context: Context): AppRepository =
        AppRepositoryImpl(context)
}