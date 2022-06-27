package com.example.a160419034_ubayakost.view

import android.view.View
import com.example.a160419034_ubayakost.model.Kost

interface KostAddClickListener {
    fun onButtonAddKost(v: View)
}

interface RadioButtonListener {
    fun onRadioClick(view: View, priority: Int, obj: Kost)
}
