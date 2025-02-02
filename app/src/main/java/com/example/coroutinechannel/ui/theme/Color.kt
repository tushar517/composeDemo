package com.example.coroutinechannel.ui.theme

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradient

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val grey_CD = Color(0xFFBCC1CD)
val black_1A = Color(0xFF1A1A1A)
val blue_F8 = Color(0xFF158BF8)
val blue_8F = Color(0xFF25408F)
val white = Color(0xFFFFFFFF)
val blue_8FF = Color(0xFFF0F6FF)
val grey_D8 = Color(0xffB8B8B8)
val magenta = Color(0xFFE10f76)

val black_16  = Color(0xFF161616)
val white_C8 = Color(0xFFC8C8C8)
val itemCardGradient = Brush.linearGradient(
    colors = listOf(
        Color(0xFF444444),
        Color(0xFF7D7783),
    ),
    start = Offset(0f,0f),
    end = Offset(0f,Float.POSITIVE_INFINITY)
)

val bottomNavCardGradient = Brush.linearGradient(
    colors = listOf(
        Color(0xFF222222),
        Color(0xFF252525),
    ),
    start = Offset(0f,0f),
    end = Offset(0f,Float.POSITIVE_INFINITY)
)