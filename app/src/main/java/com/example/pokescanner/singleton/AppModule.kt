package com.example.pokescanner.singleton

import android.content.Context
import android.util.Log
import androidx.room.Room
import com.example.pokescanner.db.CapturedPkmnDao
import com.example.pokescanner.db.CapturedPkmnDatabase
import com.example.pokescanner.db.CapturedPkmnRepository
import com.example.pokescanner.db.PokemonDao
import com.example.pokescanner.db.PokemonDatabase
import com.example.pokescanner.db.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    @Singleton
    fun providesPokemonDatabase(@ApplicationContext applicationContext: Context): PokemonDatabase {
        Log.d("AppModule", "Building Pokemondatabase from asset database/pokemon.db")
        return Room.databaseBuilder(
            applicationContext,
            PokemonDatabase::class.java,
            "pokemon_database"
        ).createFromAsset("database/pokemon.db").build()
    }

    @Provides
    fun providePokemonDao(pokemonDatabase: PokemonDatabase): PokemonDao {
        Log.d("AppModule", "Providing DAO from PokemonDatabase")
        return pokemonDatabase.pokemonDao()
    }

    @Provides
    @Singleton
    fun providesCapturedPokemonDatabase(@ApplicationContext applicationContext: Context): CapturedPkmnDatabase {
        Log.d("AppModule", "Building CapturedPokemon database")
        return Room.databaseBuilder(
            applicationContext,
            CapturedPkmnDatabase::class.java,
            "CapturedPkmn_database"
        ).build()
    }

    @Provides
    fun provideCapturePokemonDao(capturedPkmnDatabase: CapturedPkmnDatabase): CapturedPkmnDao {
        Log.d("AppModule", "Providing DAO from CapturedPkmnDatabase")
        return capturedPkmnDatabase.capturedPkmnDao()
    }


    @Provides
    @Singleton
    fun providesPokemonDatabaseRepo(pokemonDao: PokemonDao): PokemonRepository {
        Log.d("AppModule", "Providing database repository from PokemonDao")
        return PokemonRepository(pokemonDao)
    }

    @Provides
    @Singleton
    fun providesCapturedPkmnDatabaseRepo(capturedPkmnDao: CapturedPkmnDao): CapturedPkmnRepository {
        Log.d("AppModule", "Providing database repository from capturedPkmnDao")
        return CapturedPkmnRepository(capturedPkmnDao)
    }
}