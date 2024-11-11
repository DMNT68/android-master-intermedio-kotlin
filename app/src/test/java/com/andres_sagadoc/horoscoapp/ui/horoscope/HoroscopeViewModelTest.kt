package com.andres_sagadoc.horoscoapp.ui.horoscope

import com.andres_sagadoc.horoscoapp.data.motherObjetc.HorocopeMotherObject.horoscopeInfoList
import com.andres_sagadoc.horoscoapp.data.providers.HoroscopeProvider
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class HoroscopeViewModelTest {

    @MockK
    lateinit var horoscopeProvider: HoroscopeProvider

    private lateinit var viewModel: HoroscopeViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun `when ViewModel is created then horocopes are loaded`() {
        coEvery { horoscopeProvider.getHoroscopes() } returns horoscopeInfoList
        viewModel = HoroscopeViewModel(horoscopeProvider)

        val horoscopes = viewModel.horoscope.value

        Assert.assertTrue(horoscopes.isNotEmpty())
    }
}