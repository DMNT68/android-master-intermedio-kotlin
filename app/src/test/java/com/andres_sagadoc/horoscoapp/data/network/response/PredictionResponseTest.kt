package com.andres_sagadoc.horoscoapp.data.network.response

import io.kotlintest.shouldBe
import org.junit.Test

class PredictionResponseTest {

    @Test
    fun `toDomain should return correct prediction model`() {
        // Given
        val horoscopeResponse = PredictionResponse("date", "Description", "Cancer")

        // When
        val predictionModel = horoscopeResponse.toDomain()

        // Then
        predictionModel.sign shouldBe horoscopeResponse.sign
        predictionModel.horoscope shouldBe horoscopeResponse.horoscope
    }
}