package com.example.pokescanner.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.pokescanner.composables.HyperlinkText
import com.example.pokescanner.R

@Composable
fun FooterNote(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
    ) {
        HyperlinkText(
            fullText = stringResource(R.string.github_plug),
            linkText = listOf("https://github.com/lostdanielfound/PokeScanner"),
            hyperlinks = listOf("https://github.com/lostdanielfound/PokeScanner"))
        Text(stringResource(R.string.dev_note_1_en))
    }
}
