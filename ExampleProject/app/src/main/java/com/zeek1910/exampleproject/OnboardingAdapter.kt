package com.zeek1910.exampleproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class OnboardingAdapter : RecyclerView.Adapter<OnboardingViewHolder>() {

    private val items = listOf(
        OnboardingItem(
            R.string.onboarding_1_title,
            R.string.onboarding_1_description,
            R.drawable.onboarding_1
        ),
        OnboardingItem(
            R.string.onboarding_2_title,
            R.string.onboarding_2_description,
            R.drawable.onboarding_2
        ),
        OnboardingItem(
            R.string.onboarding_3_title,
            R.string.onboarding_3_description,
            R.drawable.onboarding_3
        ),
        OnboardingItem(
            R.string.onboarding_4_title,
            R.string.onboarding_4_description,
            R.drawable.onboarding_4
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_onboardin, parent, false)
        return OnboardingViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: OnboardingViewHolder, position: Int) {
        holder.bind(items[position])
    }


}