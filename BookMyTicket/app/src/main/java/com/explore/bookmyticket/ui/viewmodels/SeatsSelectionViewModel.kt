package com.explore.bookmyticket.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.explore.bookmyticket.data.pojo.ApiException
import com.explore.bookmyticket.data.utils.Constants
import com.explore.bookmyticket.domain.pojo.ApiResponse
import com.explore.bookmyticket.domain.usecase.SeatsSelectionUseCase
import com.explore.bookmyticket.ui.uistates.SeatsUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SeatsSelectionViewModel @Inject constructor(private val seatsSelectionUseCase: SeatsSelectionUseCase) :
    ViewModel() {

    // Seats UI state
    private var _uiState = MutableStateFlow(SeatsUIState(ApiResponse.Loading))
    val uiState: StateFlow<SeatsUIState>
        get() = _uiState.asStateFlow()

    private var pageNum = 0

    init {
        getSeatsSelectionResponse()
    }


    fun getSeatsSelectionResponse() {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                Log.d("TAG:", "pageNum: $pageNum")
                pageNum++
                seatsSelectionUseCase.invoke(pageNum)
            }.onSuccess { apiResponse ->
                Log.d("TAG:", "onSuccess: $pageNum")
                _uiState.emit(SeatsUIState(apiResponse))
            }.onFailure {
                _uiState.value =
                    SeatsUIState(ApiResponse.Failure(ApiException.UnknownException))
            }

        }

    }

    fun isLastPage(totalPages: Int): Boolean = pageNum >= totalPages

}