package com.example.a160419034_ubayakost.view

import android.view.View
import com.example.a160419034_ubayakost.model.Kost

interface KostAddClickListener {
    fun onButtonAddKost(v: View)
}

interface KostEditClickListener {
    fun onButtonEditKost(v: View)
}

interface KostSaveChangesListener {
    fun onSaveChangeClick(view: View, obj: Kost)
}

interface KostDetailClickListener {
    fun onKostDetailClick(view: View)
}

interface MessageAddClickListener {
    fun onButtonAddMessage(v: View)
}

interface VoucherAddClickListener {
    fun onButtonAddVoucher(v: View)
}

