package com.andres_sagadoc.horoscoapp.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.andres_sagadoc.horoscoapp.R
import com.andres_sagadoc.horoscoapp.databinding.ActivityHoroscopeDetailBinding
import com.andres_sagadoc.horoscoapp.domain.model.HoroscopeModel.Aquarius
import com.andres_sagadoc.horoscoapp.domain.model.HoroscopeModel.Aries
import com.andres_sagadoc.horoscoapp.domain.model.HoroscopeModel.Cancer
import com.andres_sagadoc.horoscoapp.domain.model.HoroscopeModel.Capricorn
import com.andres_sagadoc.horoscoapp.domain.model.HoroscopeModel.Gemini
import com.andres_sagadoc.horoscoapp.domain.model.HoroscopeModel.Leo
import com.andres_sagadoc.horoscoapp.domain.model.HoroscopeModel.Libra
import com.andres_sagadoc.horoscoapp.domain.model.HoroscopeModel.Pisces
import com.andres_sagadoc.horoscoapp.domain.model.HoroscopeModel.Sagittarius
import com.andres_sagadoc.horoscoapp.domain.model.HoroscopeModel.Scorpio
import com.andres_sagadoc.horoscoapp.domain.model.HoroscopeModel.Taurus
import com.andres_sagadoc.horoscoapp.domain.model.HoroscopeModel.Virgo
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHoroscopeDetailBinding
    private val horoscopeDetailViewModel: HoroscopeDetailViewModel by viewModels()

    private val args: HoroscopeDetailActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHoroscopeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        horoscopeDetailViewModel.getHoroscope(args.type)
    }

    private fun initUI() {
        unitListeners()
        initUIState()
    }

    private fun unitListeners() {
        binding.ivBack.setOnClickListener { this.onBackPressed() }
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopeDetailViewModel.state.collect {
                    when (it) {
                        HoroscopeDetailState.loading -> loadingState()
                        is HoroscopeDetailState.Error -> errorState()
                        is HoroscopeDetailState.Success -> successState(it)
                    }
                }
            }
        }
    }

    private fun successState(state: HoroscopeDetailState.Success) {
        binding.pbLoading.isVisible = false
        binding.tvTitle.text = state.sign
        binding.tvBody.text = state.prediction
        val image = when (state.horoscopeModel) {
            Aries -> R.drawable.detail_aries
            Taurus -> R.drawable.detail_taurus
            Gemini -> R.drawable.detail_gemini
            Cancer -> R.drawable.detail_cancer
            Leo -> R.drawable.detail_leo
            Virgo -> R.drawable.detail_virgo
            Libra -> R.drawable.detail_libra
            Scorpio -> R.drawable.detail_scorpio
            Sagittarius -> R.drawable.detail_sagittarius
            Capricorn -> R.drawable.detail_capricorn
            Aquarius -> R.drawable.detail_aquarius
            Pisces -> R.drawable.detail_pisces
        }
        binding.ivDetailHoroscope.setImageResource(image)
    }

    private fun errorState() {
        binding.pbLoading.isVisible = false
    }

    private fun loadingState() {
        binding.pbLoading.isVisible = true
    }
}