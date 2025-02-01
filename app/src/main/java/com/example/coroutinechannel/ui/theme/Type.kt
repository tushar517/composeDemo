package com.example.coroutinechannel.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.coroutinechannel.R

// Set of Material typography styles to start with
val roboto = FontFamily(
    Font(R.font.roboto_regular)
)

val typography = Typography(
    bodySmall = TextStyle(
        fontFamily = roboto,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = roboto,
        fontWeight = FontWeight.W500,
        fontSize = 18.sp,
    ),
    bodyLarge = TextStyle(
        fontFamily = roboto,
        fontWeight = FontWeight.W600,
        fontSize = 21.sp,
    )
)


