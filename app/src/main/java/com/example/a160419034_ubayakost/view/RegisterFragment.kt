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
import com.example.a160419034_ubayakost.databinding.FragmentRegisterBinding
import com.example.a160419034_ubayakost.model.Kost
import com.example.a160419034_ubayakost.model.User
import com.example.a160419034_ubayakost.viewmodel.DetailViewModel

class RegisterFragment : Fragment(), UserAddClickListener {
private lateinit var viewModel: DetailViewModel
private lateinit var dataBinding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = FragmentRegisterBinding.inflate(inflater, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        dataBinding.user = User("","")

        dataBinding.listener = this
    }

    override fun onButtonAddUser(v: View){
        dataBinding.user?.let {
            val list = listOf(it)
            viewModel.addUser(list)
            Toast.makeText(v.context, "Success Registration", Toast.LENGTH_SHORT).show()
            Navigation.findNavController(v).popBackStack()
        }
    }
}