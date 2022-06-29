package com.example.a160419034_ubayakost.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.a160419034_ubayakost.R
import com.example.a160419034_ubayakost.databinding.FragmentLoginBinding
import com.example.a160419034_ubayakost.model.User
import com.example.a160419034_ubayakost.viewmodel.DetailViewModel


class LoginFragment : Fragment(), UserLoginListener, UserRegisterListener {
    private lateinit var viewModel: DetailViewModel
    private lateinit var dataBinding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding= DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        dataBinding.loginListener=this
        dataBinding.registListener=this
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel= ViewModelProvider(this).get(DetailViewModel::class.java)
        dataBinding.user= User("", "")
    }

    override fun onUserLogin(v: View) {
        viewModel.login(dataBinding?.user!!.username, dataBinding?.user!!.password)

        if (viewModel.result=="EMPTY") {
            Toast.makeText(v.context, "please insert the username and password", Toast.LENGTH_LONG).show()
        }
        else if (viewModel.result=="WRONG") {
            Toast.makeText(v.context, "Username or password is wrong", Toast.LENGTH_LONG).show()
        }
        else if (viewModel.result=="SUCCESS") {
            Toast.makeText(v.context, "WELCOME!!", Toast.LENGTH_SHORT).show()
            val action = LoginFragmentDirections.actionHome()
            Navigation.findNavController(v).navigate(action)

        }
    }

    override fun onUserRegister(v: View) {
        val action = LoginFragmentDirections.actionRegister()
        Navigation.findNavController(v).navigate(action)
    }
}