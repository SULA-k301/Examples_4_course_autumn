package com.zeek1910.exampleproject

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class OnboardingItem(
    @StringRes val titleId: Int,
    @StringRes val descriptionId: Int,
    @DrawableRes val imageId: Int
)
