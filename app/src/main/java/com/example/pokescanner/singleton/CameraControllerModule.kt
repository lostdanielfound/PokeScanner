package com.example.pokescanner.singleton

import android.content.Context
import androidx.camera.core.CameraSelector
import androidx.camera.view.CameraController
import androidx.camera.view.LifecycleCameraController
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped

@InstallIn(ViewModelComponent::class)
@Module
object CameraControllerModule {

    @Provides
    @ViewModelScoped
    fun provideCameraController(@ApplicationContext applicationContext: Context): LifecycleCameraController {
        return LifecycleCameraController(applicationContext)
            .apply {
                setEnabledUseCases(CameraController.IMAGE_CAPTURE)
            }
    }
}