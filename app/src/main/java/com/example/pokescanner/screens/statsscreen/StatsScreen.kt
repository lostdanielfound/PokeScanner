package com.example.pokescanner.screens.statsscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.pokescanner.composables.FooterNote
import com.example.pokescanner.R
import com.example.pokescanner.composables.StatText

@Composable
fun StatsScreen(stats: Stats, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(12.dp)
            .fillMaxSize()
    ) {
        Column( /* Stats posts */
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(12.dp))
                .background(if (isSystemInDarkTheme()) Color(0xff2c2c2c) else Color(0xffd9d9d9))
                .padding(horizontal = 12.dp, vertical = 24.dp)
        ) {
            StatText(
                stringResource(R.string.total_image_taken_en),
                statInt = stats.totalImagesTaken,
                modifier = Modifier.padding(top = 24.dp, bottom = 24.dp)
            )
            StatText(
                stringResource(R.string.total_pkmn_captured_en),
                statInt = stats.totalPkmnCaptured,
                modifier = Modifier.padding(top = 24.dp, bottom = 24.dp)
            )
            StatText(
                stringResource(R.string.total_pkmn_entries_en),
                statInt = stats.totalPkmnEntriesCompleted,
                modifier = Modifier.padding(top = 24.dp, bottom = 24.dp)
            )
        }
        Spacer(modifier = Modifier.height(128.dp))
        FooterNote()
    }
}
