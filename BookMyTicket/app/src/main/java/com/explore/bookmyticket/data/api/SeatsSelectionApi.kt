package com.explore.bookmyticket.data.api

import com.explore.bookmyticket.data.pojo.SeatsInfoApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SeatsSelectionApi {

    @GET("/v3/{endPoint}")
    suspend fun getSeatsSelectionInfo(@Path("endPoint") path: String): Response<SeatsInfoApiResponse>
}