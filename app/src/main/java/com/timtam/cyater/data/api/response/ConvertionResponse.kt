package com.timtam.cyater.data.api.response


import com.google.gson.annotations.SerializedName
import retrofit2.http.GET

data class ConvertionResponse(
    @SerializedName("IDR_USD")
    val fromTo: Double,
    @SerializedName("USD_IDR")
    val toFrom: Int
)