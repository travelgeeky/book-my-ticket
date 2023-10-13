package com.explore.bookmyticket.data.repo

import com.explore.bookmyticket.data.api.SeatsSelectionApi
import com.explore.bookmyticket.data.pojo.LayoutInfo
import com.explore.bookmyticket.domain.pojo.ApiResponse
import com.explore.bookmyticket.domain.repo.SeatsSelectionRepository
import com.explore.bookmyticket.data.utils.ErrorUtils
import com.explore.bookmyticket.data.utils.SeatSelectionUtils.getPageNumPath
import javax.inject.Inject

/**
 * Repository Implementation for all the data calls for Seat Selection Screen
 * This is used to fetch data from either a network source or database
 */

class SeatsSelectionRepositoryImpl @Inject constructor(private val seatsSelectionApi: SeatsSelectionApi) :
    SeatsSelectionRepository {

    override suspend fun getSeatsSelectionResponse(pageNum: Int): ApiResponse<LayoutInfo> {
        val response =
            seatsSelectionApi.getSeatsSelectionInfo(getPageNumPath(pageNum))
        return if (!response.isSuccessful) {
            ApiResponse.Failure(
                ErrorUtils.getApiError(
                    errorCode = response.code()
                )
            )
        } else {
            ApiResponse.Success(
                response.body()?.bookMyTicket?.layoutInfo ?: LayoutInfo()
            )
        }

    }
}