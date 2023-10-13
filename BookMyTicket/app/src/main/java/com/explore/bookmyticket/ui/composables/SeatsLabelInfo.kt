package com.explore.bookmyticket.ui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.explore.bookmyticket.R

@Composable
fun SeatsLabelInfo(modifier: Modifier) {
    Row(
        modifier = modifier.padding(horizontal = 8.dp)
            .fillMaxWidth()
            .background(Color.White),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(32.dp)
                .padding(bottom = 4.dp, top = 2.dp, start = 8.dp)
                .background(Color.Gray)
                .border(
                    BorderStroke(1.dp, Color.Gray)
                )
        )
        Text(modifier = Modifier
            .padding(start = 4.dp),
            text = LocalContext.current.getString(R.string.seat_label_sold),
            color = Color.Gray
        )
        Box(
            modifier = Modifier
                .size(32.dp)
                .padding(bottom = 4.dp, top = 4.dp, start = 8.dp)
                .border(
                    BorderStroke(1.dp, Color.Blue)
                )
        )
        Text(modifier = Modifier
            .padding(start = 4.dp),
            text = LocalContext.current.getString(R.string.seat_label_available),
            color = Color.Gray
        )
        Box(
            modifier = Modifier
                .size(32.dp)
                .padding(bottom = 4.dp, top = 4.dp, start = 8.dp)
                .background(Color.Blue)
                .border(
                    BorderStroke(1.dp, Color.Blue)
                )
        )
        Text( modifier = Modifier
            .padding(start = 4.dp),
            text = LocalContext.current.getString(R.string.seat_label_selected),
            color = Color.Gray
        )
    }
}
