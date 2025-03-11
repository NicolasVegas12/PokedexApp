package com.nvegas.data.di

import android.content.Context
import androidx.room.Room
import com.nvegas.data.database.PokedexDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppDatabaseProvider {

    private const val DATABASE_NAME = "pokedex_app_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context): PokedexDatabase {
        return Room.databaseBuilder(
            context,
            PokedexDatabase::class.java,
            DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    @Singleton
    @Provides
    fun providePokemonDao(pokedexDatabase: PokedexDatabase) = pokedexDatabase.getPokemonDao()


}