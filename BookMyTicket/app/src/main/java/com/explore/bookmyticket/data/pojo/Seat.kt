package com.explore.bookmyticket.data.pojo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Seat (

    @SerializedName("gridSeatNum" ) val gridSeatNum : Int?,
    @SerializedName("seatStatus"  ) val seatStatus  : String?,
    @SerializedName("seatNumber"  ) val seatNumber  : Int?

): Parcelable