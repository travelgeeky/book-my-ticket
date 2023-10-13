package com.explore.bookmyticket.domain.pojo

import com.explore.bookmyticket.data.pojo.ApiException
import java.lang.Exception


sealed class ApiResponse<out T: Any>{
    data class Success<out T: Any>(val data: T): ApiResponse<T>()
    data class Failure(val exception: ApiException): ApiResponse<Nothing>()
    object Loading: ApiResponse<Nothing>()
}