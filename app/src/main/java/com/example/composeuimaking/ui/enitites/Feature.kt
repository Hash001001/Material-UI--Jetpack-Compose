package com.example.composeuimaking.ui.enitites

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class Feature(
    val title: String,
    @DrawableRes val icon : Int,
    val bgColor : Color
)
