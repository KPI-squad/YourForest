package com.example.trees42.features.auth

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.trees42.base.BaseFragment
import com.example.trees42.databinding.FragmentAuthBinding
import com.example.trees42.databinding.FragmentHomeBinding
import com.example.trees42.features.home.HomeFragment
import com.example.trees42.features.home.HomeFragmentDirections
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class AuthFragment: BaseFragment<FragmentAuthBinding>(), AuthContract{

    @Inject
    lateinit var presenter: AuthPresenter

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentAuthBinding {
        return FragmentAuthBinding.inflate(inflater, container, false)
    }

    override fun attachToPresenter() {
        presenter.attachView(this)
    }

    override fun initView() {
        setupListeners()
    }

    private fun setupListeners(){
        binding.authLoginButton.setOnClickListener {
            presenter.onGoogleLoginCLicked()
        }
    }

    override fun startHomeFragment() {
        HomeFragment.start(findNavController())
    }
}