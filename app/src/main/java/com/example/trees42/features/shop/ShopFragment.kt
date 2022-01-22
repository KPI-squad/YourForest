package com.example.trees42.features.shop

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trees42.base.BaseFragment
import com.example.trees42.databinding.FragmentShopBinding
import com.example.trees42.model.Tree
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ShopFragment: BaseFragment<FragmentShopBinding>(), ShopContract {

    @Inject
    lateinit var presenter: ShopPresenter

    @Inject
    lateinit var adapter: RecycleViewAdapter

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentShopBinding {
        return FragmentShopBinding.inflate(inflater, null, false)
    }

    override fun attachToPresenter() {
        presenter.attachView(this)
    }

    override fun initView() {

        binding.shopRecycleView.layoutManager = LinearLayoutManager(requireContext())
        binding.shopRecycleView.adapter = adapter
    }

    override fun updateUI(data: MutableList<Tree>) {
        adapter.setData(data)
    }

}