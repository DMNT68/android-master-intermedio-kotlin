package com.andres_sagadoc.horoscoapp.data.motherObjetc

import com.andres_sagadoc.horoscoapp.data.network.response.PredictionResponse
import com.andres_sagadoc.horoscoapp.domain.model.HoroscopeInfo

object HorocopeMotherObject {

    val anyReponse = PredictionResponse("date", "prediction", "sign")

    val horoscopeInfoList = listOf(
        HoroscopeInfo.Aries,
        HoroscopeInfo.Taurus,
        HoroscopeInfo.Gemini,
        HoroscopeInfo.Cancer,
        HoroscopeInfo.Leo,
        HoroscopeInfo.Virgo,
        HoroscopeInfo.Libra,
        HoroscopeInfo.Scorpio,
        HoroscopeInfo.Sagittarius,
        HoroscopeInfo.Capricorn,
        HoroscopeInfo.Aquarius,
        HoroscopeInfo.Pisces
    )
}