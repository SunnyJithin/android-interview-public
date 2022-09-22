package com.clearbridgemobile.challenge1.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import com.clearbridgemobile.challenge1.R

@Composable
fun AndroidInterviewTheme(
    content: @Composable () -> Unit
) {
    val colors = lightColors(
        primary = colorResource(R.color.purple_200),
        primaryVariant = colorResource(R.color.purple_700),
        secondary = colorResource(R.color.teal_200)
    )
    MaterialTheme(
        colors = colors,
        content = content
    )
}