package com.explore.bookmyticket.ui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.explore.bookmyticket.data.pojo.Seat
import com.explore.bookmyticket.ui.utils.SeatSelectionUtils


@Composable
fun SeatItem(
    seat: Seat,
    modifier: Modifier,
    ticketCount: MutableState<Int>,
    maxTicketCount: Int,
    onSeatSelected: (seatCount: Int, seat: Seat, isExceeded: Boolean) -> Unit
) {

    val isReserved : State<Boolean> = rememberSaveable{
        mutableStateOf((seat.seatStatus?: false) == SeatSelectionUtils.IS_RESERVED)
    }

    val isSelected: MutableState<Boolean> = rememberSaveable {
       mutableStateOf((seat.seatStatus ?: SeatSelectionUtils.IS_AVAILABLE) == SeatSelectionUtils.IS_SELECTED)
    }


    Box(
        modifier = modifier
            .size(54.dp)
            .padding(horizontal = 4.dp)
            .background(
                if (isReserved.value) Color.Gray else {
                    if (isSelected.value) Color.Blue else Color.White
                }
            )
            .border(
                BorderStroke(
                    1.dp, if (isReserved.value) Color.Gray else Color.Blue
                )
            )
            .clickable(enabled = !isReserved.value,
                onClick = {
                    if (!(isSelected.value) && ticketCount.value >= maxTicketCount) {
                        onSeatSelected(ticketCount.value, seat, true)
                    }else{
                        isSelected.value = !isSelected.value
                        onSeatSelected(if (isSelected.value) ticketCount.value+1 else ticketCount.value-1, seat, false)
                    }
                }),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = seat.seatNumber.toString(),
            color = if (isReserved.value) Color.LightGray else { if(isSelected.value) Color.White else Color.Black }
        )
    }
}

