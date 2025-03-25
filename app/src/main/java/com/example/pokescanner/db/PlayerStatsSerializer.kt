package com.example.pokescanner.db

import androidx.compose.animation.defaultDecayAnimationSpec
import androidx.datastore.core.Serializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream

@Suppress("BlockingMethodInNonBlockingContext")
object PlayerStatsSerializer : Serializer<PlayerStats> {
    override val defaultValue: PlayerStats
        get() = PlayerStats(
            0,
            0,
            0,
        )

    override suspend fun readFrom(input: InputStream): PlayerStats {
        return try {
            Json.decodeFromString(
                deserializer = PlayerStats.serializer(),
                string = input.readBytes().decodeToString() // Reading json directly from input stream
            )
        } catch(e: SerializationException) {
            e.printStackTrace()
            defaultValue // Return the defaultValue upon serialization failure
        }
    }

    override suspend fun writeTo(t: PlayerStats, output: OutputStream) {
        output.write(
            Json.encodeToString(
                serializer = PlayerStats.serializer(),
                value = t
            ).encodeToByteArray()
        )
    }

}