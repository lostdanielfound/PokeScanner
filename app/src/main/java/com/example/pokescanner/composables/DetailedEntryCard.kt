package com.example.pokescanner.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pokescanner.R
import com.example.pokescanner.db.NullPokemon
import com.example.pokescanner.db.Pokemon
import com.example.pokescanner.utils.BitmapConverter

@Composable
fun DetailedEntryCard(loadingPokemon: Pokemon) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.Large_Padding))
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(dimensionResource(id = R.dimen.Large_Padding))
    ) {
        Column {
            if (loadingPokemon.thumbnail != null) {
                BitmapConverter.converterStringToBitmap(loadingPokemon.thumbnail)
                    ?.let {
                        Thumbnail(
                            bitmap = it.asImageBitmap(),
                            contentDescription = loadingPokemon.name,
                            size = dimensionResource(R.dimen.Large_Thumbnail_Size)
                        )
                    }
            } else {
                Thumbnail(
                    painter = painterResource(id = R.drawable.question),
                    contentDescription = "Loading",
                    size = dimensionResource(id = R.dimen.Large_Thumbnail_Size)
                )
            }
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.Medium_Padding)),
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.Small_Padding))
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.Small_Padding)),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
            ) {
                Text(
                    text = "ID #${loadingPokemon.ID}",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = loadingPokemon.name,
                    style = MaterialTheme.typography.titleLarge
                )
            }
            Row {
                Text(
                    text = loadingPokemon.species,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Row(horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.Small_Padding))) {
                TypeIcon(loadingPokemon.type1)
                if (loadingPokemon.type2 != null) {
                    TypeIcon(loadingPokemon.type2)
                }
            }
            Row(horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.Small_Padding))) {
                Text(
                    text = "Ht " + if (loadingPokemon.height == 0.0) "x.xx" else loadingPokemon.height.toString(),
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "Wt " + if (loadingPokemon.weight == 0.0) "x.xx" else loadingPokemon.weight.toString(),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Composable
fun TypeIcon(typeName: String) {
    val cardColor: Color = when (typeName) {
        "Normal" -> Color(0xffaaaa99)
        "Fire" -> Color(0xffec4225)
        "Water" -> Color(0xff4e9afe)
        "Electric" -> Color(0xfff5cc34)
        "Grass" -> Color(0xff77cc55)
        "Ice" -> Color(0xff66ccff)
        "Fighting" -> Color(0xffbb5545)
        "Poison" -> Color(0xffa85498)
        "Ground" -> Color(0xffaa5599)
        "Flying" -> Color(0xff8899ff)
        "Psychic" -> Color(0xffee5499)
        "Bug" -> Color(0xffaabb22)
        "Rock" -> Color(0xffbbaa66)
        "Ghost" -> Color(0xff6667bc)
        "Dragon" -> Color(0xff7867ee)
        else -> Color.White
    }

    OutlinedCard(
        shape = CutCornerShape(2.dp),
        border = BorderStroke(1.dp, Color.Black),
        colors = CardDefaults.cardColors(
            containerColor = cardColor
        ),
        modifier = Modifier
            .size(width = 54.dp, height = 22.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = typeName,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailedEntryCardPreview() {
    val demoPokemon: Pokemon = NullPokemon.getNullPokemon()
    DetailedEntryCard(loadingPokemon = demoPokemon)
}