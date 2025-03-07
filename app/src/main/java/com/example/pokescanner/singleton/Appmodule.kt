package com.example.pokescanner.singleton

import android.content.Context
import com.example.pokescanner.db.PokemonDatabase
import com.example.pokescanner.db.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Appmodule {

    @Provides
    @Singleton
    fun providesDatabaseRepository(@ApplicationContext applicationContext: Context): PokemonRepository {
        val pokemonDao = PokemonDatabase.getDatabase(context = applicationContext).pokemonDao()
        return PokemonRepository(pokemonDao)
    }
}