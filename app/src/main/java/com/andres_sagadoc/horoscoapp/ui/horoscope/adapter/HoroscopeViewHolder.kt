package com.andres_sagadoc.horoscoapp.ui.horoscope.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.andres_sagadoc.horoscoapp.databinding.ItemHoroscopeBinding
import com.andres_sagadoc.horoscoapp.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopeBinding.bind(view)

    fun render(horoscopeInfo: HoroscopeInfo) {
        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvHoroscope.text = binding.tvHoroscope.context.getString(horoscopeInfo.name)
    }
}