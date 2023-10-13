package com.explore.bookmyticket.data.pojo

import android.os.Parcelable
import com.explore.bookmyticket.data.utils.Constants
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class LayoutInfo (

    @SerializedName("rows" ) var rows : ArrayList<Rows> = arrayListOf(),
    @SerializedName("maxSeatsPerRow"   ) var totalSeats   : Int? = Constants.MAX_SEATS_PER_ROW,
    @SerializedName("movieDetails" ) var movieDetails : MovieDetails? = MovieDetails(),
    @SerializedName("pageNum"      ) var pageNum      : Int=1,

    ): Parcelable