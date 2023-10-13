package com.explore.bookmyticket.ui.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.explore.bookmyticket.data.pojo.LayoutInfo
import com.explore.bookmyticket.data.utils.Constants
import com.explore.bookmyticket.domain.pojo.ApiResponse
import com.explore.bookmyticket.ui.composables.buttons.BookingButton
import com.explore.bookmyticket.ui.uistates.SeatsUIState
import com.explore.bookmyticket.ui.viewmodels.SeatsSelectionViewModel

/**
 * Parent Screen to handle and show all the information(Movie and Theatre detail,
 * Seats Selection View and the confirm button)
 * @param seatsSelectionViewModel viewModel to fetch required info in this Composable
 */
@Composable
fun SeatsSelectionScreen(
    modifier: Modifier, uiState: SeatsUIState,
    maxTicketLimit: Int,
    seatsSelectionViewModel: SeatsSelectionViewModel
) {
    val layoutInfo: LayoutInfo =
        (uiState.apiResponse as ApiResponse.Success).data

    val ticketCount: MutableState<Int> = rememberSaveable {
        mutableStateOf(0)
    }

    Box(
        modifier = modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally) {
            MovieDetailsLayout(
                modifier = modifier,
                movieDetails = layoutInfo.movieDetails,
                maxTicketLimit = maxTicketLimit)
            SeatsLayout(
                modifier = modifier.padding(top = 16.dp, bottom = 16.dp),
                totalPages = Constants.TOTAL_PAGES,
                layoutInfo.rows,
                ticketCount,
                seatsSelectionViewModel = seatsSelectionViewModel
            )
        }
        Column(
            modifier = modifier.align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally) {
            BookingButton(
                modifier = modifier,
                ticketCount.value,
                maxTicketLimit
            )
            SeatsLabelInfo(modifier = modifier)
        }
    }
}


