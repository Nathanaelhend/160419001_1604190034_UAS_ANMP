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
import kotlinx.android.synthetic.main.fragment_message_list.*
import kotlinx.android.synthetic.main.fragment_message_list.recViewVoucher
import kotlinx.android.synthetic.main.fragment_message_list.refreshLayoutVoucher

class MessageListFragment : Fragment() {

    private lateinit var viewModel: ListViewModel
    private var messageListAdapter = MessageListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_message_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refreshMessage()

        recViewVoucher.layoutManager = LinearLayoutManager(context)
        recViewVoucher.adapter = messageListAdapter

        refreshLayoutVoucher.setOnRefreshListener {
            recViewVoucher.visibility = View.GONE

            progressLoad.visibility = View.VISIBLE
            viewModel.refresh()
            refreshLayoutVoucher.isRefreshing = false
            textError.visibility= View.GONE
        }

        fabAddMessage.setOnClickListener {
            val action = MessageListFragmentDirections.actionItemMessageToAddMessageFragment()
            Navigation.findNavController(it).navigate(action)
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.MessageLD.observe(viewLifecycleOwner){
            messageListAdapter.updateMessageList(it)
        }
//        viewModel.LoadErrorLiveData.observe(viewLifecycleOwner){
//            textError.visibility = if(it) View.VISIBLE else View.GONE
//        }
//        viewModel.loadingLiveData.observe(viewLifecycleOwner){
//            if(it){ //sedang loading
//                recViewVoucher.visibility = View.GONE
//                progressLoad.visibility  = View.VISIBLE
//            }
//            else{
//                recViewVoucher.visibility = View.VISIBLE
//                progressLoad.visibility = View.GONE
//                textError.visibility = View.GONE
//            }
//        }
    }
}