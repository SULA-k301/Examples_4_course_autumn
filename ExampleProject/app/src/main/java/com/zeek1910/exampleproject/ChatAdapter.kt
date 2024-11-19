package com.zeek1910.exampleproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ChatAdapter : RecyclerView.Adapter<TextMessageViewHolder>() {

    private val items = mutableListOf<TextMessage>()

    fun setMessages(messages: List<TextMessage>) {
        items.clear()
        items.addAll(messages)
        notifyDataSetChanged()
    }

    fun addMessage(message: TextMessage) {
        items.add(message)
        notifyItemInserted(items.size - 1)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextMessageViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_text_message, parent, false)
        return TextMessageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: TextMessageViewHolder, position: Int) {
        holder.bind(items[position])
    }
}