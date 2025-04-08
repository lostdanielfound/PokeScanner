package com.example.pokescanner.screens.homescreen

import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.icu.text.SimpleDateFormat
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.widget.Toast
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.Preview
import androidx.camera.view.PreviewView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokescanner.db.CapturedPkmnRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class HomeViewmodel @Inject constructor(
    private val capturedPkmnImpl: CapturedPkmnRepository
): ViewModel() {

    private val _homeState = MutableStateFlow(HomeState())
    val homeState: StateFlow<HomeState> = _homeState.asStateFlow()

    /**
     * onPhotoTaken will process the respective image as a bitmap
     * through a pokemon classification model to make the best prediction of the pokemon
     * identified in the image.
     *
     * Once analysis is complete, a dialog alert should pop-up showing the prediction.
     * Image should be recorded within the CapturedPkmn DB.
     */
    fun onPhotoTaken(context: Context, bitmap: Bitmap) {
        //Preprocessing media happenes here

        saveImage(context, bitmap)
    }

    private fun saveImage(context: Context, bitmap: Bitmap) {
        viewModelScope.launch {
            val filenamePattern = "yyyy-MM-dd"
            val dateString = SimpleDateFormat(
                filenamePattern,
                Locale.ENGLISH,
            ).format(System.currentTimeMillis())
            val filename = "PokeScanner-${dateString}"

            val directoryPath = Environment.DIRECTORY_DCIM + "/PokeScanner"
            val nowTimestamp = System.currentTimeMillis()

            val contentValues = ContentValues().apply {
                put(MediaStore.MediaColumns.DISPLAY_NAME, filename)
                put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    put(MediaStore.MediaColumns.DATE_TAKEN, nowTimestamp)
                    put(MediaStore.MediaColumns.RELATIVE_PATH, directoryPath)
                    put(MediaStore.MediaColumns.IS_PENDING, 1)
                }

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    put(MediaStore.Images.Media.DATE_TAKEN, nowTimestamp)
                    put(MediaStore.Images.Media.DATE_ADDED, nowTimestamp)
                    put(MediaStore.Images.Media.DATE_MODIFIED, nowTimestamp)
                }
            }

            val contentResolver = context.contentResolver
            val imageCollection: Uri = when { // Determining the Image collection
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q ->
                    MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY)
                else ->
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            }
            //The URL of the newly created row
            val uri = contentResolver.insert(imageCollection, contentValues)

            if (uri != null) {
                try {
                    val outputStream = contentResolver.openOutputStream(uri)
                    outputStream.use {
                        if (it != null) {
                            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, it)
                        }
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                        contentValues.clear()
                        contentValues.put(MediaStore.MediaColumns.IS_PENDING, 0)
                        contentResolver.update(uri, contentValues, null, null)
                    }
                } catch (exception: Exception) {
                    exception.printStackTrace()
                }
            }
        }
    }

    fun resetState() {
        _homeState.value = HomeState(temp = 0)
    }
}