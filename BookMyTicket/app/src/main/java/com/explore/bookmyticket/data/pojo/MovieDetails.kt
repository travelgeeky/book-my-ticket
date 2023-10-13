package com.explore.bookmyticket.data.pojo

import android.os.Parcelable
import com.explore.bookmyticket.data.utils.Constants
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieDetails (

    @SerializedName("movieName"   ) var movieName   : String? = null,
    @SerializedName("movieTag"    ) var movieTag    : String? = null,
    @SerializedName("theatreName" ) var theatreName : String?    = Constants.EMPTY_STRING,
    @SerializedName("areaCode"    ) var areaCode    : String? = null,
    @SerializedName("dateAndTime" ) var dateAndTime : String? = null,
    @SerializedName("ticketLimit" ) var ticketLimit : Int?    = 1

): Parcelable