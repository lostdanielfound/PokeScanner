package com.example.pokescanner.screens.homescreen

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel

class HomeViewmodel(): ViewModel() {

    private var _homeState = MutableStateFlow(homeState())
    private val homeState = _homeState.asStateFlow()
    /**
     * onPhotoTaken will process the respective image as a bitmap
     * through a pokemon classification model to make the best prediction of the pokemon
     * identified in the image.
     *
     * Once analysis is complete, a dialog alert should pop-up showing the prediction.
     * Image should be recorded within the CapturedPkmn DB.
     */
    fun onPhotoTaken(bitmap: Bitmap) {

    }

    resetState() {
        _homeState.value = homeState()
    }
}