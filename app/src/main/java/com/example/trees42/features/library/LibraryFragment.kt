package com.example.trees42.features.library

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.trees42.base.BaseFragment
import com.example.trees42.databinding.FragmentLibraryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LibraryFragment : BaseFragment<FragmentLibraryBinding>() {

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentLibraryBinding {
        return FragmentLibraryBinding.inflate(inflater, null, false)
    }

    override fun initView() {

    }
}