package com.explore.bookmyticket.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RowLabelItem(rowLabel: String, modifier: Modifier) {
    Box(
        modifier = modifier
            .size(54.dp)
            .background(Color.Transparent),
            contentAlignment = Alignment.Center,
    ) {
        Text(
            text = rowLabel
        )
    }
}