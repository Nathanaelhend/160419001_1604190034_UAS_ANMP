package com.example.a160419034_ubayakost.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.a160419034_ubayakost.R
import com.example.a160419034_ubayakost.databinding.FragmentAddKostBinding
import com.example.a160419034_ubayakost.databinding.KostListItemBinding
import com.example.a160419034_ubayakost.model.Kost
//import com.example.a160419034_ubayakost.util.loadImage
import kotlinx.android.synthetic.main.fragment_kost_list.view.*
import kotlinx.android.synthetic.main.kost_list_item.view.*

class KostListAdapter(val kostList: ArrayList<Kost>) : RecyclerView
.Adapter<KostListAdapter.KostListViewHolder>(), KostDetailClickListener, KostEditClickListener {
    class KostListViewHolder(var view: KostListItemBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KostListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = KostListItemBinding.inflate(inflater, parent, false)

        return KostListViewHolder(view)
    }

    override fun onBindViewHolder(holder: KostListViewHolder, position: Int) {

            val kost = kostList[position]
            holder.view.kost = kost
            holder.view.detailListener = this@KostListAdapter
            holder.view.editListener = this

    }
    override fun getItemCount() =kostList.size

    fun updateKostList(newKostList: List<Kost>){
        kostList.clear()
        kostList.addAll(newKostList)
        notifyDataSetChanged()
    }

    override fun onKostDetailClick(view: View) {
        val uuid = view.tag.toString().toInt()
        val action = KostListFragmentDirections.actionKostDetail(uuid)
        Navigation.findNavController(view).navigate(action)
    }

    override fun onButtonEditKost(view: View) {
        val uuid = view.tag.toString().toInt()
        val action = KostListFragmentDirections.actionHomeToEdit(uuid)
        Navigation.findNavController(view).navigate(action)
    }

}