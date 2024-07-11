package com.example.pokescanner.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Thumbnail(painter: Painter, contentDescription: String?, size: Dp) {
    Image(
        painter = painter,
        contentScale = ContentScale.Fit,
        contentDescription = contentDescription,
        modifier = Modifier
            .size(size)
            .clip(CircleShape)
            .border(
                BorderStroke(4.dp, MaterialTheme.colorScheme.onPrimaryContainer),
                CircleShape
            )
            .background(Color.White)
    )
}

@Composable
fun Thumbnail(bitmap: ImageBitmap, contentDescription: String?, size: Dp) {
    Image(
        bitmap = bitmap,
        contentDescription = contentDescription,
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .size(size) // For compact sizes, this size should work
            .border(
                BorderStroke(4.dp, MaterialTheme.colorScheme.onPrimaryContainer),
                CircleShape
            )
            .clip(CircleShape)
            .background(Color.White)
    )
}
