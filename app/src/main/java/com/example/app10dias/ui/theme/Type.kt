package com.example.app10dias.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.sp
import com.example.app10dias.R

val ubuntu1 = FontFamily(
    Font(R.font.ubuntu_regular)
)
val ubuntu2 = FontFamily(
    Font(R.font.ubuntu_bolditalic)
)
val ubuntu3 = FontFamily(
    Font(R.font.ubuntu_italic)
)
val ubuntu4 = FontFamily(
    Font(R.font.ubuntu_light)
)
val ubuntu5 = FontFamily(
    Font(R.font.ubuntu_bold)
)
// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = ubuntu5,
        fontSize = 18.sp,
        lineHeight = 15.sp,
        letterSpacing = 0.5.sp
    ),
    displayLarge = TextStyle(
        fontFamily = ubuntu2,
        fontSize = 15.sp
    ),
    displayMedium = TextStyle(
        fontFamily = ubuntu3,
        fontSize = 15.sp
    ),
    displaySmall = TextStyle(
        fontFamily = ubuntu4,
        fontSize = 16.sp
    )
)