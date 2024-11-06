package com.andres_sagadoc.horoscoapp.ui.detail

import androidx.lifecycle.ViewModel
import com.andres_sagadoc.horoscoapp.domain.useCase.GetPredictionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopeDetailViewModel @Inject constructor(private val getPredictionUseCase: GetPredictionUseCase) : ViewModel() {
    private var _state = MutableStateFlow<HoroscopeDetailState>(HoroscopeDetailState.loading)
    val state: StateFlow<HoroscopeDetailState> = _state
}