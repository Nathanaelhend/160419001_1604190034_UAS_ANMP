package com.example.a160419034_ubayakost.view

import android.view.View
import com.example.a160419034_ubayakost.model.Kost

interface KostAddClickListener {
    fun onButtonAddKost(v: View)
}

interface UserAddClickListener {
    fun onButtonAddUser(v: View)
}

interface KostDetailClickListener {
    fun onKostDetailClick(view: View)
}

interface UserLoginListener {
    fun onUserLogin(v: View)
}

interface UserRegisterListener {
    fun onUserRegister(v: View)
}

interface RadioButtonListener {
    fun onRadioClick(view: View, priority: Int, obj: Kost)
}
