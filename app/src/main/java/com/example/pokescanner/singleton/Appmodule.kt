package com.example.pokescanner.singleton

import com.example.pokescanner.db.PokemonDatabase
import com.example.pokescanner.db.PokemonRepository
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
abstract class Appmodule {
    @Provides
    fun providesDatabaseRepository(): PokemonRepository {
        //TODO need to figure out how to pass in the Application context
        val pokemonDao = PokemonDatabase.getDatabase(ApplicationContext).pokemonDao()
        return PokemonRepository(pokemonDao)
    }
}