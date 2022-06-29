package com.example.a160419034_ubayakost.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.a160419034_ubayakost.R
import com.example.a160419034_ubayakost.databinding.FragmentAddKostBinding
import com.example.a160419034_ubayakost.databinding.FragmentEditKostBinding
import com.example.a160419034_ubayakost.model.Kost
import com.example.a160419034_ubayakost.viewmodel.DetailViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [EditKostFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EditKostFragment : Fragment(), KostSaveChangesListener {
    private lateinit var viewModel: DetailViewModel
    private lateinit var dataBinding: FragmentEditKostBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = FragmentEditKostBinding.inflate(inflater, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        val uuid = EditKostFragmentArgs.fromBundle(requireArguments()).uuid
        viewModel.fetch(uuid)

        observeView()
    }

    private fun observeView() {
        viewModel.kostLD.observe(viewLifecycleOwner) {
            dataBinding.kost = it
        }
    }

    override fun onSaveChangeClick(view: View, obj: Kost) {
        viewModel.update(obj)
        Toast.makeText(view.context, "Update Success", Toast.LENGTH_SHORT).show()
    }


}