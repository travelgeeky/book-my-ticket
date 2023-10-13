package com.explore.bookmyticket.data.pojo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class BookMyTicket (

    @SerializedName("pageNum"      ) var pageNum      : Int=1,
    @SerializedName("totalPages"   ) var totalPages   : Int,
    @SerializedName("rowsPerPage"  ) var rowsPerPage  : Int,
    @SerializedName("totalRows"    ) var totalRows    : Int,
    @SerializedName("layoutInfo"   ) var layoutInfo   : LayoutInfo?  = LayoutInfo()

): Parcelable