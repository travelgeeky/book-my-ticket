package com.explore.bookmyticket.ui.utils

import android.content.Context
import com.explore.bookmyticket.R
import com.explore.bookmyticket.data.pojo.ApiException

object ErrorMessageUtils {

    fun getErrorMessage(apiException: ApiException, context: Context): String{
        return when(apiException){
            is ApiException.ServerException-> context.getString(R.string.server_error_msg)
            is ApiException.AuthenticationException-> context.getString(R.string.auth_error_msg)
            is ApiException.UnknownException-> context.getString(R.string.unknown_error_msg)
        }
    }
}