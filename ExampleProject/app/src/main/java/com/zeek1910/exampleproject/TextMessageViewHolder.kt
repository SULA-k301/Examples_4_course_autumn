package com.zeek1910.exampleproject

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TextMessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val message = itemView.findViewById<TextView>(R.id.message)
    private val time = itemView.findViewById<TextView>(R.id.time)

    fun bind(item: TextMessage) {
        message.text = item.message
        time.text = item.time.toString()
    }
}