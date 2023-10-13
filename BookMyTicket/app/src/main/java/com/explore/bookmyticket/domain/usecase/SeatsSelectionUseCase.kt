package com.explore.bookmyticket.domain.usecase

import com.explore.bookmyticket.data.pojo.LayoutInfo
import com.explore.bookmyticket.domain.pojo.ApiResponse
import com.explore.bookmyticket.data.pojo.Rows
import com.explore.bookmyticket.domain.repo.SeatsSelectionRepository
import javax.inject.Inject

class SeatsSelectionUseCase @Inject constructor(private val seatsSelectionRepository: SeatsSelectionRepository) {

    private suspend fun getSeatsSelectionInfo(pageNum: Int): ApiResponse<LayoutInfo> = seatsSelectionRepository.getSeatsSelectionResponse(pageNum)

    suspend operator fun invoke(pageNum: Int): ApiResponse<LayoutInfo> {
        return getSeatsSelectionInfo(pageNum)
    }
}