package com.example.pokescanner.screens.homescreen

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Matrix
import android.util.Log
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture.OnImageCapturedCallback
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.ImageProxy
import androidx.camera.view.CameraController
import androidx.camera.view.LifecycleCameraController
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material.icons.filled.Cameraswitch
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.example.pokescanner.R
import com.example.pokescanner.composables.CameraPreview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onPhotoTaken: (Bitmap) -> Unit,
    modifier: Modifier = Modifier
) {
    val scaffoldState = rememberBottomSheetScaffoldState()
    val appContext = LocalContext.current // Current application context

    // Camera Controller, this val should only be modified or used within the HomeScreen
    val controller = remember {
        LifecycleCameraController(appContext).apply {
            setEnabledUseCases( // Can only capture images
                CameraController.IMAGE_CAPTURE
            )
        }
    }

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetPeekHeight = 0.dp,
        sheetContent = {
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            CameraPreview(
                controller = controller,
                modifier = Modifier
                    .fillMaxSize()
            )
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(dimensionResource(id = R.dimen.Large_Padding))
            ) {
                /* CameraSwitch Button */
                IconButton(
                    onClick = {
                        controller.cameraSelector = if (controller.cameraSelector == CameraSelector.DEFAULT_BACK_CAMERA) {
                            CameraSelector.DEFAULT_FRONT_CAMERA
                        } else CameraSelector.DEFAULT_BACK_CAMERA
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Cameraswitch,
                        contentDescription = "Camera Switch",
                    )
                }

                /* Take Picture Button */
                IconButton(
                    onClick = {
                        takePhoto(
                            controller,
                            onPhotoTaken,
                            appContext
                        )
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Camera,
                        contentDescription = "Take Picture"
                    )
                }
            }
        }
    }
}

private fun takePhoto(
    controller: LifecycleCameraController,
    onPhotoTaken: (Bitmap) -> Unit,
    context: Context
) {
    controller.takePicture(
        ContextCompat.getMainExecutor(context),
        object : OnImageCapturedCallback() {
            override fun onCaptureSuccess(image: ImageProxy) {
                super.onCaptureSuccess(image)

                //Image is initially rotated by default, need to rotated from landscape to portrait
                val matrix = Matrix().apply {
                    postRotate(image.imageInfo.rotationDegrees.toFloat()) // Applies rotation
                    // postScale(-1f, 1f) // If needed, mirrors the image on the X axis
                }
                val rotatedBitmap = Bitmap.createBitmap(
                    image.toBitmap(),
                    0,
                    0,
                    image.width,
                    image.height,
                    matrix,
                    true
                )

                onPhotoTaken(rotatedBitmap)
            }

            override fun onError(exception: ImageCaptureException) {
                super.onError(exception)
                Log.e("Camera", "Failed to take picture", exception)
            }
        }
    )
}

/**
 * onPhotoTaken will process the respective image as a bitmap
 * through a pokemon classification model to make the best prediction of the pokemon
 * identified in the image.
 *
 * Once analysis is complete, a dialog alert should pop-up showing the prediction.
 * Image should be recorded within the CapturedPkmn DB.
 */