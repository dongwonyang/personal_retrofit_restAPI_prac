package com.example.retrofit.presentation.search.main

import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

data class SearchMainTapModel (
    val fragment: Fragment,
    @StringRes val title: Int
)