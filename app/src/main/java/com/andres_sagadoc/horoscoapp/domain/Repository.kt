package com.andres_sagadoc.horoscoapp.domain

import com.andres_sagadoc.horoscoapp.domain.model.PredictionModel

interface Repository {
    suspend fun getPredictions(sing: String): PredictionModel?
}