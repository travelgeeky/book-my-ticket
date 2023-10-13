package com.explore.bookmyticket.ui.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import com.explore.bookmyticket.data.pojo.Rows
import com.explore.bookmyticket.data.pojo.Seat
import com.explore.bookmyticket.data.utils.Constants
import com.explore.bookmyticket.ui.utils.SeatSelectionUtils

@Composable
fun RowItem(
    modifier: Modifier,
    rows: Rows,
    ticketCount: MutableState<Int>,
    onSeatSelected: (seatCount: Int, seat: Seat, isExceeded: Boolean) -> Unit
) {
    Row {
        RowLabelItem(
            rowLabel = rows.rowDesc, modifier = modifier
        )
        rows.seats?.let { seats->
            LazyRow(content = {
                items(Constants.MAX_SEATS_PER_ROW) { index ->
                    if (SeatSelectionUtils.isEmptyCell(index, rows.totalSeats)) {
                        EmptyItem(modifier = modifier)
                    } else {
                        SeatItem(
                            seat = seats[index - SeatSelectionUtils.getFirstValidIndex(rows.totalSeats)],
                            modifier = modifier,
                            ticketCount = ticketCount,
                            maxTicketCount = 2,
                            onSeatSelected
                        )
                    }
                }
            })
        }
    }
}
