package com.example.pokescanner.composables

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.example.pokescanner.db.Pokemon
import com.example.pokescanner.utils.BitmapConverter
import com.example.pokescanner.R

/* Create new user interaction.
* When entry is clicked, show the pkmn's full entry card
* and details. Backstack should be the pokedex screen
* */

@Composable
fun EntryCardRow(pkmn: Pokemon, onClick: (Int) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(8.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primaryContainer)
            .clickable { onClick(pkmn.ID) }
            .fillMaxWidth()
    ) {
        pkmn.thumbnail?.let { imageString ->
            BitmapConverter.converterStringToBitmap(imageString)?.let { image ->
                Log.w("EntryCardRow.Compose", "Bitmap Conversion Proceeded for ${pkmn.name}")
                Thumbnail(
                    bitmap = image.asImageBitmap(),
                    contentDescription = pkmn.name,
                    size = dimensionResource(id = R.dimen.Medium_Thumbnail_Size)
                )
            }
        }
        Spacer(modifier = Modifier.width(12.dp))
        Column(
            modifier = Modifier
                .padding(start = 4.dp, end = 4.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(start = 4.dp, end = 8.dp)
            ) {
                Text(
                    text = "#" + pkmn.ID.toString(),
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier
                        .padding(start = 0.dp, end = 4.dp)
                )
                Text(
                    text = pkmn.name,
                    style = MaterialTheme.typography.titleLarge
                )
            }
            Row(
                modifier = Modifier
                    .padding(4.dp)
            ) {
                Text(
                    text = pkmn.description,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}
