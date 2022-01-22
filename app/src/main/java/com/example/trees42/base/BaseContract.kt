package com.example.trees42.base

import androidx.annotation.StringRes

interface BaseContract {

    fun showToast(text: String)

    fun showToast(@StringRes text: Int)
}