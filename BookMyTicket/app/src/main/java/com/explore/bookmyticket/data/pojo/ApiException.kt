package com.explore.bookmyticket.data.pojo

sealed class ApiException {

    object ServerException : ApiException()
    object AuthenticationException : ApiException()
    object UnknownException : ApiException()

}