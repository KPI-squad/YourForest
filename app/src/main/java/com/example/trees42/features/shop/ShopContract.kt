package com.example.trees42.features.shop

import com.example.trees42.base.BaseContract
import com.example.trees42.model.Tree

interface ShopContract: BaseContract {

    fun updateUI(data: MutableList<Tree>)
}