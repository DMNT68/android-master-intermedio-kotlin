package com.andres_sagadoc.horoscoapp.data

import android.util.Log
import com.andres_sagadoc.horoscoapp.data.network.HoroscopeApiService
import com.andres_sagadoc.horoscoapp.domain.Repository
import com.andres_sagadoc.horoscoapp.domain.model.PredictionModel
import javax.inject.Inject

class RepositoryImplementation @Inject constructor(private val apiServidce: HoroscopeApiService) :
    Repository {

    override suspend fun getPredictions(sing: String): PredictionModel? {
        kotlin.runCatching { apiServidce.getHoroscope(sing) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("Andres", "Ha ocurrido un error ${it.message}") }
        return null
    }
}