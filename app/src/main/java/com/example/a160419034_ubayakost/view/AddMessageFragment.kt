package com.example.a160419034_ubayakost.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.a160419034_ubayakost.R
import com.example.a160419034_ubayakost.databinding.FragmentAddKostBinding
import com.example.a160419034_ubayakost.databinding.FragmentAddMessageBinding
import com.example.a160419034_ubayakost.model.Kost
import com.example.a160419034_ubayakost.model.Message
import com.example.a160419034_ubayakost.viewmodel.DetailViewModel

class AddMessageFragment : Fragment(), MessageAddClickListener {
private lateinit var viewModel: DetailViewModel
private lateinit var dataBinding: FragmentAddMessageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = FragmentAddMessageBinding.inflate(inflater, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        dataBinding.message = Message("")

        dataBinding.listener = this
    }

    override fun onButtonAddMessage(v: View) {
        dataBinding.message?.let {
            val list = listOf(it)
            viewModel.addMessage(list)
            Toast.makeText(v.context, "Data Added", Toast.LENGTH_SHORT).show()
            Navigation.findNavController(v).popBackStack()
        }
    }

}