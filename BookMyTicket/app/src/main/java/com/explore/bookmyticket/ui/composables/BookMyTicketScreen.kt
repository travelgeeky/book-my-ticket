package com.explore.bookmyticket.ui.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.explore.bookmyticket.domain.pojo.ApiResponse
import com.explore.bookmyticket.ui.uistates.SeatsUIState
import com.explore.bookmyticket.ui.viewmodels.SeatsSelectionViewModel

/**
 * Top UI Screen for this App
 */
@Composable
fun BookMyTicketScreen(
    modifier: Modifier,
    seatsSelectionViewModel: SeatsSelectionViewModel = viewModel()
) {

    val uiState = seatsSelectionViewModel.uiState.collectAsStateWithLifecycle().value
    UiStateHandle(modifier, uiState, seatsSelectionViewModel)
}

/**
 * Api response handler
 */
@Composable
fun UiStateHandle(
    modifier: Modifier,
    uiState: SeatsUIState,
    seatsSelectionViewModel: SeatsSelectionViewModel
) {
    when (uiState.apiResponse) {
        is ApiResponse.Success -> {
            SeatsSelectionScreen(
                modifier = modifier,
                uiState,
                maxTicketLimit = 2,
                seatsSelectionViewModel = seatsSelectionViewModel
            )
        }

        is ApiResponse.Failure -> {
            ErrorLayout(modifier, (uiState.apiResponse).exception) {
                seatsSelectionViewModel.getSeatsSelectionResponse()
            }
        }

        is ApiResponse.Loading -> {
            LoadingScreen(modifier)
        }
    }
}