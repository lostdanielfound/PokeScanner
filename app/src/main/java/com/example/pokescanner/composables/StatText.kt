package com.example.pokescanner.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun StatText(text: String, modifier: Modifier = Modifier, statInt: Int = -1) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
    ){
        Text(
            text,
            fontSize = 20.sp,
            fontWeight = FontWeight.Light,
        )
        Text(
            if (statInt == -1) "#" else statInt.toString(),
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold
        )
    }
}
