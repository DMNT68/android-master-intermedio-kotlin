package com.andres_sagadoc.horoscoapp.domain.useCase

import com.andres_sagadoc.horoscoapp.domain.Repository
import javax.inject.Inject

class GetPredictionUseCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(sing: String) = repository.getPredictions(sing)
}