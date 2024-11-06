package com.andres_sagadoc.horoscoapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andres_sagadoc.horoscoapp.domain.model.HoroscopeModel
import com.andres_sagadoc.horoscoapp.domain.useCase.GetPredictionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HoroscopeDetailViewModel @Inject constructor(private val getPredictionUseCase: GetPredictionUseCase) :
    ViewModel() {
    private var _state = MutableStateFlow<HoroscopeDetailState>(HoroscopeDetailState.loading)
    val state: StateFlow<HoroscopeDetailState> = _state

    lateinit var horoscope: HoroscopeModel

    fun getHoroscope(sign: HoroscopeModel) {
        horoscope = sign
        viewModelScope.launch {
            // Hilo pricipal
            _state.value = HoroscopeDetailState.loading
            withContext(Dispatchers.IO) {
                // Hilo secundario
                val result = getPredictionUseCase(sign.name)
                if (result != null) {
                    _state.value =
                        HoroscopeDetailState.Success(result.horoscope, result.sign, horoscope)
                } else {
                    _state.value =
                        HoroscopeDetailState.Error("Ha ocurrido un error, intentalo mas tarde")
                }
            }
            // Hilo principal
        }
    }
}