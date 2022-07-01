package com.example.a160419034_ubayakost.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a160419034_ubayakost.R
import com.example.a160419034_ubayakost.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_kost_list.*
import kotlinx.android.synthetic.main.fragment_voucher.*


class KostListFragment : Fragment() {
    private lateinit var viewModel: ListViewModel
    private var kostListAdapter = KostListAdapter(arrayListOf())


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kost_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refresh()

        recViewKost.layoutManager = LinearLayoutManager(context)
        recViewKost.adapter = kostListAdapter

        refreshLayoutKost.setOnRefreshListener {
            recViewKost.visibility = View.GONE

            progresLoad.visibility = View.VISIBLE
            viewModel.refresh()
            refreshLayoutKost.isRefreshing = false
            txtErrorKost.visibility= View.GONE
        }
        fabAddKost.setOnClickListener {
            val action = KostListFragmentDirections.actionToAddKost()
            Navigation.findNavController(it).navigate(action)
        }
        observeViewModel()
    }


    private fun observeViewModel() {
        viewModel.KostLD.observe(viewLifecycleOwner){
            kostListAdapter.updateKostList(it)

            if(it.isEmpty()){ //sedang loading
                recViewKost.visibility = View.GONE
                progresLoad.visibility  = View.VISIBLE
            }
            else{
                recViewKost.visibility = View.VISIBLE
                progresLoad.visibility = View.GONE
                txtErrorKost.visibility = View.GONE
            }
        }
    }
}