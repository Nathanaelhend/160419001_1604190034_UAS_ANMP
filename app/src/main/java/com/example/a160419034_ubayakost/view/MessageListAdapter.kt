package com.example.a160419034_ubayakost.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.a160419034_ubayakost.R
import com.example.a160419034_ubayakost.databinding.MessageListItemBinding
import com.example.a160419034_ubayakost.model.Kost
import com.example.a160419034_ubayakost.model.Message
import com.example.a160419034_ubayakost.model.Voucher
import kotlinx.android.synthetic.main.message_list_item.view.*

class MessageListAdapter(val messageList: ArrayList<Message>) : RecyclerView
.Adapter<MessageListAdapter.messageViewHolder>(){
    class messageViewHolder(var view : MessageListItemBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): messageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = MessageListItemBinding.inflate(inflater, parent, false)
        return messageViewHolder(view)
    }

    fun updateMessageList(newMessageList: List<Message>){
        messageList.clear()
        messageList.addAll(newMessageList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: messageViewHolder, position: Int) {
        val message = messageList[position]

        holder.view.message = message

    }

    override fun getItemCount() = messageList.size


}