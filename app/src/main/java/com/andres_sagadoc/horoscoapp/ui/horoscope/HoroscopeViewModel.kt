package com.andres_sagadoc.horoscoapp.ui.horoscope

import androidx.lifecycle.ViewModel
import com.andres_sagadoc.horoscoapp.domain.model.HoroscopeInfo
import com.andres_sagadoc.horoscoapp.domain.model.HoroscopeInfo.Aries
import com.andres_sagadoc.horoscoapp.domain.model.HoroscopeInfo.Cancer
import com.andres_sagadoc.horoscoapp.domain.model.HoroscopeInfo.Gemini
import com.andres_sagadoc.horoscoapp.domain.model.HoroscopeInfo.Taurus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopeViewModel @Inject constructor() : ViewModel() {

    private var _horoscope = MutableStateFlow<List<HoroscopeInfo>>(emptyList())
    val horoscope: StateFlow<List<HoroscopeInfo>> = _horoscope

    init {
        _horoscope.value = listOf(
            Aries,
            Taurus,
            Gemini,
            Cancer,
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

}