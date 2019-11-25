package com.timtam.cyater.data.api

import com.timtam.cyater.BuildConfig.API_KEY
import retrofit2.http.GET
import retrofit2.http.Path

object RetrofitClient {

    interface Api {
        @GET("currencies?apiKey={apiKey}")
        fun getCurrencies(@Path("apiKey") key: String = API_KEY)

        @GET("convert?q={convert}&compact=ultra&apiKey={apiKey}")
        fun getConvertion(
            @Path("convert") conv: String,
            @Path("apiKey") key: String = API_KEY
        )

        @GET("convert?q={convert}&compact=ultra&date={dateStart}&endDate={dateEnd}&apiKey={apiKey}")
        fun getHistorical(
            @Path("convert") conv: String,
            @Path("dateStart") start: String,
            @Path("dateEnd") end: String,
            @Path("apiKey") key: String = API_KEY
        )
    }
}