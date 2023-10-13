package com.explore.bookmyticket.ui.composables

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.explore.bookmyticket.R
import com.explore.bookmyticket.data.pojo.Rows
import com.explore.bookmyticket.data.pojo.Seat
import com.explore.bookmyticket.data.utils.Constants
import com.explore.bookmyticket.ui.utils.SeatSelectionUtils
import com.explore.bookmyticket.ui.viewmodels.SeatsSelectionViewModel

/**
 * Seat Selection Grid view with seats available and reserved status initially
 */
@Composable
fun SeatsLayout(
    modifier: Modifier,
    totalPages: Int,
    movieRows: ArrayList<Rows>,
    ticketCount: MutableState<Int>,
    seatsSelectionViewModel: SeatsSelectionViewModel
) {

    val listState = rememberLazyListState()

    val rows: ArrayList<Rows> = rememberSaveable {
        arrayListOf()
    }
    if (!rows.containsAll(movieRows)) rows.addAll(movieRows)


    val context: Context = LocalContext.current.applicationContext
    LazyColumn(
        modifier = Modifier.padding(bottom = 16.dp),
        state = listState,
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceEvenly,
        content = {
            items(items = rows, key = {
                it.gridRowId.toString()
            }) { row ->
                RowItem(modifier = modifier,
                    rows = row,
                    ticketCount,
                    onSeatSelected = { seatCount, seat, isExceeded ->
                        onSeatSelection(
                            context = context,
                            seatCount = seatCount,
                            seat = seat,
                            isExceeded = isExceeded,
                            ticketCount
                        )
                    })
            }
        })
    listState.OnBottomReached {
        if (!seatsSelectionViewModel.isLastPage(totalPages)) seatsSelectionViewModel.getSeatsSelectionResponse()
    }
}


fun onSeatSelection(
    context: Context,
    seatCount: Int,
    seat: Seat,
    isExceeded: Boolean,
    ticketCount: MutableState<Int>
) {
    if (isExceeded) {
        Toast.makeText(
            context, context.getString(R.string.tickets_limit_exceeded), Toast.LENGTH_SHORT
        ).show()
    } else {
        ticketCount.value = seatCount
    }
}

