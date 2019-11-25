package com.timtam.cyater.data.api.response


import com.google.gson.annotations.SerializedName

data class HistoricalResponse(
    @SerializedName("USD_IDR")
    val result: RESULT
) {
    data class RESULT(
        @SerializedName("2019-01-02")
        val x20190102: Double,
        @SerializedName("2019-01-03")
        val x20190103: Double,
        @SerializedName("2019-01-04")
        val x20190104: Double,
        @SerializedName("2019-01-05")
        val x20190105: Int,
        @SerializedName("2019-01-06")
        val x20190106: Int,
        @SerializedName("2019-01-07")
        val x20190107: Int,
        @SerializedName("2019-01-08")
        val x20190108: Int,
        @SerializedName("2019-01-09")
        val x20190109: Int,
        @SerializedName("2019-01-10")
        val x20190110: Int
    )
}