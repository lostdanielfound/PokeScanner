package com.example.pokescanner.screens.homescreen

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import com.example.pokescanner.db.CapturedPkmnRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewmodel @Inject constructor(
    capturedPkmnImpl: CapturedPkmnRepository
): ViewModel() {

    private val _homeState = MutableStateFlow(HomeState(temp = 0))
    val homeState: StateFlow<HomeState> = _homeState.asStateFlow()
    /**
     * onPhotoTaken will process the respective image as a bitmap
     * through a pokemon classification model to make the best prediction of the pokemon
     * identified in the image.
     *
     * Once analysis is complete, a dialog alert should pop-up showing the prediction.
     * Image should be recorded within the CapturedPkmn DB.
     */
    fun onPhotoTaken(bitmap: Bitmap) {
        //Preprocessing media happenes here

        // savePhoto(bitmap)
    }

    private fun savePhoto(bitmap: Bitmap) {

    }

    fun resetState() {
        _homeState.value = HomeState(temp = 0)
    }
}