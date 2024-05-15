package com.example.pokescanner.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokescanner.R

val ubuntuFontFamily = FontFamily(
    Font(R.font.ubuntu_regular, FontWeight.Normal),
    Font(R.font.ubuntu_bold, FontWeight.Bold),
    Font(R.font.ubuntu_light, FontWeight.Light),
    Font(R.font.ubuntu_medium, FontWeight.Medium)
)

val Typography = Typography(
    displayLarge = TextStyle(
        fontSize = 57.sp,
        fontFamily = ubuntuFontFamily,
        fontWeight = FontWeight.Normal,
        lineHeight = 64.sp,
    ),
    displayMedium = TextStyle(
        fontSize = 45.sp,
        fontFamily = ubuntuFontFamily,
        fontWeight = FontWeight.Normal,
        lineHeight = 52.sp,
    ),
    displaySmall = TextStyle(
        fontSize = 36.sp,
        fontFamily = ubuntuFontFamily,
        fontWeight = FontWeight.Normal,
        lineHeight = 44.sp,
    ),
    headlineLarge = TextStyle(
        fontSize = 32.sp,
        fontFamily = ubuntuFontFamily,
        fontWeight = FontWeight.Normal,
        lineHeight = 40.sp,
    ),
    headlineMedium = TextStyle(
        fontSize = 28.sp,
        fontFamily = ubuntuFontFamily,
        fontWeight = FontWeight.Normal,
        lineHeight = 36.sp,
    ),
    headlineSmall = TextStyle(
        fontSize = 24.sp,
        fontFamily = ubuntuFontFamily,
        fontWeight = FontWeight.Normal,
        lineHeight = 32.sp,
    ),
    titleLarge = TextStyle(
        fontSize = 22.sp,
        fontFamily = ubuntuFontFamily,
        fontWeight = FontWeight.Normal,
        lineHeight = 28.sp,
    ),
    titleMedium = TextStyle(
        fontSize = 16.sp,
        fontFamily = ubuntuFontFamily,
        fontWeight = FontWeight.Normal,
        lineHeight = 24.sp,
    ),
    titleSmall = TextStyle(
        fontSize = 14.sp,
        fontFamily = ubuntuFontFamily,
        fontWeight = FontWeight.Normal,
        lineHeight = 20.sp,
    ),
    bodySmall = TextStyle(
        fontSize = 12.sp,
        fontFamily = ubuntuFontFamily,
        fontWeight = FontWeight.Normal,
        lineHeight = 16.sp,
    ),
    bodyMedium = TextStyle(
        fontSize = 14.sp,
        fontFamily = ubuntuFontFamily,
        fontWeight = FontWeight.Normal,
        lineHeight = 20.sp,
    ),
    bodyLarge = TextStyle(
        fontSize = 16.sp,
        fontFamily = ubuntuFontFamily,
        fontWeight = FontWeight.Normal,
        lineHeight = 24.sp,
    ),
    labelSmall = TextStyle(
        fontSize = 11.sp,
        fontFamily = ubuntuFontFamily,
        fontWeight = FontWeight.Normal,
        lineHeight = 16.sp,
    ),
    labelMedium = TextStyle(
        fontSize = 12.sp,
        fontFamily = ubuntuFontFamily,
        fontWeight = FontWeight.Normal,
        lineHeight = 16.sp,
    ),
    labelLarge = TextStyle(
        fontSize = 14.sp,
        fontFamily = ubuntuFontFamily,
        fontWeight = FontWeight.Normal,
        lineHeight = 20.sp,
    ),

)