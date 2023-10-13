package com.explore.bookmyticket.data.utils

object SeatSelectionUtils {

    private const val SEAT_SELECTION_PAGE_ONE_PATH = "7babb8f2-e020-41c4-a244-e8cde6119a83"
    private const val SEAT_SELECTION_PAGE_TWO_PATH = "35380ed5-d5af-4cd0-8711-ac59dd89f8f2"
    private const val SEAT_SELECTION_PAGE_THREE_PATH = "f82c38dc-5ce4-4257-a542-fb31ef1f6bbb"
    private const val SEAT_SELECTION_PAGE_FOUR_PATH = "c778a337-f425-4f47-b388-41067f5a4889"

    fun getPageNumPath(pageNum: Int): String{
        return when(pageNum){
            1 -> SEAT_SELECTION_PAGE_ONE_PATH
            2 -> SEAT_SELECTION_PAGE_TWO_PATH
            3 -> SEAT_SELECTION_PAGE_THREE_PATH
            4 -> SEAT_SELECTION_PAGE_FOUR_PATH
            else -> SEAT_SELECTION_PAGE_ONE_PATH
        }
    }

}