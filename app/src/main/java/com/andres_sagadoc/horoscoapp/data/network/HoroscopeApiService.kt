package com.andres_sagadoc.horoscoapp.data.network

import com.andres_sagadoc.horoscoapp.data.network.response.PredictionResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface HoroscopeApiService {
    @GET("/{sign}")
    suspend fun getHoroscope(@Path("sign") sing: String): PredictionResponse
}
