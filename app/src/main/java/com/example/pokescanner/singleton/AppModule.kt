package com.example.pokescanner.singleton

import android.content.Context
import android.util.Log
import androidx.room.Room
import com.example.pokescanner.db.CapturedPkmnDao
import com.example.pokescanner.db.CapturedPkmnRepository
import com.example.pokescanner.db.CommonDatabase
import com.example.pokescanner.db.PlayerStatsDao
import com.example.pokescanner.db.PlayerStatsRepository
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
    fun providesPokemonDatabaseRepo(pokemonDao: PokemonDao): PokemonRepository {
        Log.d("AppModule", "Providing database repository from PokemonDao")
        return PokemonRepository(pokemonDao)
    }

    @Provides
    @Singleton
    fun providesCommonDatabase(@ApplicationContext applicationContext: Context): CommonDatabase {
        Log.d("AppModule", "Building Common database")
        return Room.databaseBuilder(
            applicationContext,
            CommonDatabase::class.java,
            "Common_database"
        ).build()
    }

    @Provides
    fun provideCapturedPkmnDao(commonDatabase: CommonDatabase): CapturedPkmnDao {
        return commonDatabase.capturedPkmnDao()
    }

    @Provides
    @Singleton
    fun provideCapturedPkmnRepo(capturedPkmnDao: CapturedPkmnDao): CapturedPkmnRepository {
        return CapturedPkmnRepository(capturedPkmnDao)
    }

    @Provides
    fun providePlayerStatsDao(commonDatabase: CommonDatabase): PlayerStatsDao {
        return commonDatabase.playerStatsDao()
    }

    @Provides
    @Singleton
    fun providePlayerStatsRepo(playerStatsDao: PlayerStatsDao): PlayerStatsRepository {
        return PlayerStatsRepository(playerStatsDao)
    }

}