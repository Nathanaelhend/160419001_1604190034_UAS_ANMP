package com.example.a160419034_ubayakost.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.a160419034_ubayakost.R
import com.example.a160419034_ubayakost.databinding.VoucherListItemBinding
import com.example.a160419034_ubayakost.model.Kost
import com.example.a160419034_ubayakost.model.Voucher
//import com.example.a160419034_ubayakost.util.loadImage
import kotlinx.android.synthetic.main.voucher_list_item.view.*

class VoucherListAdapter(val voucherList: ArrayList<Voucher>) : RecyclerView
.Adapter<VoucherListAdapter.voucherViewHolder>(){
    class voucherViewHolder(var view: VoucherListItemBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): voucherViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = VoucherListItemBinding.inflate(inflater, parent, false)
        return voucherViewHolder(view)
    }

    fun updateVoucherList(newVoucherList: List<Voucher>){
        voucherList.clear()
        voucherList.addAll(newVoucherList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: voucherViewHolder, position: Int) {
        val voucher = voucherList[position]
        holder.view.voucher = voucher
    }

    override fun getItemCount() = voucherList.size
}