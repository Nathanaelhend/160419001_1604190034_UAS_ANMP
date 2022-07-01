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
import com.example.a160419034_ubayakost.databinding.FragmentAddVoucherBinding
import com.example.a160419034_ubayakost.model.Message
import com.example.a160419034_ubayakost.model.Voucher
import com.example.a160419034_ubayakost.viewmodel.DetailViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [AddVoucherFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddVoucherFragment : Fragment(), VoucherAddClickListener {
    private lateinit var viewModel: DetailViewModel
    private lateinit var dataBinding: FragmentAddVoucherBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = FragmentAddVoucherBinding.inflate(inflater, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        dataBinding.voucher = Voucher("", "", "", "")

        dataBinding.listener = this
    }

    override fun onButtonAddVoucher(v: View) {
        dataBinding.voucher?.let {
            val list = listOf(it)
            viewModel.addVoucher(list)
            Toast.makeText(v.context, "Data Added", Toast.LENGTH_SHORT).show()
            Navigation.findNavController(v).popBackStack()
        }
    }
}