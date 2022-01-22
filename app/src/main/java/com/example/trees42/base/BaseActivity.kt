package com.example.trees42.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import dagger.hilt.android.AndroidEntryPoint

abstract class BaseActivity<
        VB : ViewBinding
        > : AppCompatActivity() {

    private var viewBinding: VB? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding=createViewBinding(LayoutInflater.from(this)).also {
            setContentView(it.root)
        }
    }

    protected abstract fun createViewBinding(inflater: LayoutInflater): VB
}