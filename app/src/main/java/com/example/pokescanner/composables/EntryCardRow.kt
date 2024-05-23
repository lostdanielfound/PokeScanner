package com.example.pokescanner.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokescanner.R
import com.example.pokescanner.db.Pokemon
import com.example.pokescanner.utils.BitmapConverter

@Composable
fun EntryCardRow(pkmn: Pokemon, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(8.dp)
            .clip(CircleShape)
            .background(Color(0xffc8c8c8))
            .fillMaxWidth()
    ) {
        val borderWidth = 4.dp
        BitmapConverter.converterStringToBitmap(pkmn.thumbnail)?.let {
            Image(
                bitmap = it.asImageBitmap(),
                contentDescription = pkmn.name,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(88.dp)
                    .border(
                        BorderStroke(borderWidth, Color.LightGray),
                        CircleShape
                    )
                    .padding(borderWidth)
                    .clip(CircleShape)
                    .background(Color.White)
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
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
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(start = 0.dp, end = 4.dp)
                )
                Text(
                    text = pkmn.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }
            Row(
                modifier = Modifier
                    .padding(4.dp)
            ) {
                Text(
                    text = pkmn.description,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}
