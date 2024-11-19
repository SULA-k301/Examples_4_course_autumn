package com.zeek1910.exampleproject

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OnboardingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val image = itemView.findViewById<ImageView>(R.id.image)
    private val title = itemView.findViewById<TextView>(R.id.title)
    private val description = itemView.findViewById<TextView>(R.id.description)

    fun bind(item: OnboardingItem) {
        image.setImageResource(item.imageId)
        title.setText(item.titleId)
        description.setText(item.descriptionId)
    }
}