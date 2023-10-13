package com.explore.bookmyticket.ui.uistates

import com.explore.bookmyticket.data.pojo.LayoutInfo
import com.explore.bookmyticket.data.pojo.Rows
import com.explore.bookmyticket.domain.pojo.ApiResponse

data class SeatsUIState(val apiResponse: ApiResponse<LayoutInfo>)