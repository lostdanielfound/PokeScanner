package com.example.pokescanner

import android.media.Image

// A Pokemon object is going to consist of the follow:
/*
* Name: String,
* PokedexID: Int,
* Type: List<String>,
* Description: String,
* Picture: Mat Image?
*
* */
data class Pokemon(val name: String,
                   val pokedexID: Int,
                   val type: List<String>,
                   val description: String,
                   var picture: Image){

}