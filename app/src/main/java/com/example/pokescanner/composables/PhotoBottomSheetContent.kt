package com.example.pokescanner.composables

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.dimensionResource
import com.example.pokescanner.R

@Composable
fun PhotoBottomSheetContent(
    bitmaps: List<Bitmap>,
    modifier: Modifier = Modifier
) {
    if(bitmaps.isEmpty()) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
                .padding(dimensionResource(id = R.dimen.Large_Padding))
        ) {
            Text("Lol no photos")
        }
    } else {
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.Large_Padding)),
            verticalItemSpacing = dimensionResource(id = R.dimen.Large_Padding),
            contentPadding = PaddingValues(dimensionResource(id = R.dimen.Large_Padding)),
            modifier = modifier,
        ) {
            items(bitmaps) { bitmap ->
                Image(
                    bitmap = bitmap.asImageBitmap(),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(RoundedCornerShape(dimensionResource(id = R.dimen.Rounded_Medium_Corner)))
                )
            }
        }
    }
}