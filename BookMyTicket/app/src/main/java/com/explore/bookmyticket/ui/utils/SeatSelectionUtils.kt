package com.explore.bookmyticket.ui.utils

import com.explore.bookmyticket.data.pojo.MovieDetails
import com.explore.bookmyticket.data.utils.Constants
import java.lang.StringBuilder

object SeatSelectionUtils {

    const val IS_RESERVED = "1"
    const val IS_AVAILABLE = "0"
    const val IS_SELECTED =  "2"

    fun getFirstValidIndex(totalSeats: Int?): Int {
        val seatsSize = totalSeats?:(Constants.MAX_SEATS_PER_ROW -1)
        return Constants.MAX_SEATS_PER_ROW - seatsSize
    }

    fun isEmptyCell(index: Int, totalSeats: Int?): Boolean{
        return index < SeatSelectionUtils.getFirstValidIndex(totalSeats)
    }

    fun getTheatreAndMovieDetail(movieDetails: MovieDetails): String{
        val result = StringBuilder()
        result
            .append(movieDetails.theatreName)
            .append(Constants.COLON_DELIMITER)
            .append(Constants.SPACE_STRING)
            .append(movieDetails.areaCode)
            .append(Constants.PIP_DELIMITER)
            .append(movieDetails.dateAndTime)
        return result.toString()
    }
}