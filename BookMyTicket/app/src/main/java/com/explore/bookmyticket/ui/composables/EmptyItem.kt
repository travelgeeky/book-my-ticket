package com.explore.bookmyticket.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun EmptyItem(modifier: Modifier) {
    Box(
        modifier = modifier
            .size(54.dp)
            .padding(horizontal = 4.dp)
            .background(Color.Transparent)
    )
}