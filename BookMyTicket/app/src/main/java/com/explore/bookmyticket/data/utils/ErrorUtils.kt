package com.explore.bookmyticket.data.utils

import com.explore.bookmyticket.data.pojo.ApiException

object ErrorUtils {


    fun getApiError(errorCode: Int): ApiException {

        return if ((400..404).contains(errorCode)) {
            ApiException.AuthenticationException
        } else if ((500..504).contains(errorCode)) {
            ApiException.ServerException
        } else {
            ApiException.UnknownException
        }
    }
}