package com.explore.bookmyticket.ui.composables.buttons

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.explore.bookmyticket.R

/**
 * Next Button to confirm booking.
 *  This will be enable only once required seats are selected.
 */
@Composable
fun BookingButton(modifier: Modifier, ticketCount: Int, maxTicketLimit: Int) {
    val context = LocalContext.current
    Button(
        modifier = modifier
            .padding(12.dp),
        onClick = {Toast.makeText(
            context,
            context.getString(R.string.ticket_confirmation_msg),
            Toast.LENGTH_SHORT
        ).show() },
        enabled = ticketCount >= maxTicketLimit
    ){
        Text(text = LocalContext.current.getString(R.string.confirm_booking_btn),
        color = MaterialTheme.colorScheme.surface
        )
    }
}