package com.example.myapplication.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

val fontFamily = FontFamily(
    Font(R.font.unifrakturmaguntia_regular, FontWeight.Normal)
)

// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = TextStyle(
        fontWeight = FontWeight.W400,
        fontFamily = fontFamily,
        fontSize = 57.sp,
        letterSpacing = (-0.25).sp
    ),
    displayMedium = TextStyle(
        fontWeight = FontWeight.W400,
        fontFamily = fontFamily,
        fontSize = 45.sp,
    ),
    displaySmall = TextStyle(
        fontWeight = FontWeight.W400,
        fontFamily = fontFamily,
        fontSize = 36.sp,
    ),
    headlineLarge = TextStyle(
        fontWeight = FontWeight.W400,
        fontFamily = fontFamily,
        fontSize = 32.sp,
    ),
    headlineMedium = TextStyle(
        fontWeight = FontWeight.W400,
        fontFamily = fontFamily,
        fontSize = 28.sp,
    ),
    headlineSmall = TextStyle(
        fontWeight = FontWeight.W400,
        fontFamily = fontFamily,
        fontSize = 17.sp,
    ),
    titleLarge = TextStyle(
        fontWeight = FontWeight.W700,
        fontFamily = fontFamily,
        fontSize = 20.sp,
    ),
    titleMedium = TextStyle(
        fontWeight = FontWeight.W700,
        fontFamily = fontFamily,
        fontSize = 18.sp,
    ),
    titleSmall = TextStyle(
        fontWeight = FontWeight.W500,
        fontFamily = fontFamily,
        fontSize = 16.sp,
    ),
    bodyLarge = TextStyle(
        fontWeight = FontWeight.W400,
        fontFamily = fontFamily,
        fontSize = 15.sp,
    ),
    bodyMedium = TextStyle(
        fontWeight = FontWeight.W400,
        fontFamily = fontFamily,
        fontSize = 14.sp,
    ),
    bodySmall = TextStyle(
        fontWeight = FontWeight.W400,
        fontFamily = fontFamily,
        fontSize = 12.sp,
    ),
    labelLarge = TextStyle(
        fontWeight = FontWeight.W400,
        fontFamily = fontFamily,
        fontSize = 12.sp,
    ),
    labelMedium = TextStyle(
        fontWeight = FontWeight.W400,
        fontFamily = fontFamily,
        fontSize = 10.sp,
    ),
    labelSmall = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.W500,
        fontSize = 8.sp,
    ),
)
