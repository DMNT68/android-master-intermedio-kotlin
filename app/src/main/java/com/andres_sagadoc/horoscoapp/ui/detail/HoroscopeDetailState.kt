package com.andres_sagadoc.horoscoapp.ui.detail

import com.andres_sagadoc.horoscoapp.domain.model.HoroscopeModel

sealed class HoroscopeDetailState {
    data object loading : HoroscopeDetailState()
    data class Error(val error: String) : HoroscopeDetailState()
    data class Success(val prediction: String, val sign: String, val horoscopeModel: HoroscopeModel) : HoroscopeDetailState()
}