package com.explore.bookmyticket.data.pojo

import android.os.Parcelable
import com.explore.bookmyticket.data.utils.Constants
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Rows (

    @SerializedName("gridRowId"    ) val gridRowId    : Int?,
    @SerializedName("rowDesc"      ) val rowDesc      : String,
    @SerializedName("categoryId"   ) val categoryId   : Int,
    @SerializedName("categoryName" ) val categoryName : String,
    @SerializedName("totalSeats"   ) val totalSeats   : Int? = Constants.MAX_SEATS_PER_ROW,
    @SerializedName("seats"        ) val seats        : ArrayList<Seat>? = arrayListOf()

): Parcelable