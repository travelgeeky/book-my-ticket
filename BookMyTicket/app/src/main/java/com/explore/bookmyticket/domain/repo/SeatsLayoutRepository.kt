package com.explore.bookmyticket.domain.repo

import com.explore.bookmyticket.data.pojo.LayoutInfo
import com.explore.bookmyticket.domain.pojo.ApiResponse
import com.explore.bookmyticket.data.pojo.Rows

/**
 * Repository Contract to have all the data calls at one place for Seat Selection Screen
 * This is also useful if we want to mock it in a testcase without actually worrying about its implementation
 */
interface SeatsSelectionRepository {
    suspend fun getSeatsSelectionResponse(pageNum: Int): ApiResponse<LayoutInfo>
}