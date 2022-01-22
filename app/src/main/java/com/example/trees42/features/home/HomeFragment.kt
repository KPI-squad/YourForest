package com.example.trees42.features.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.trees42.R
import com.example.trees42.base.BaseFragment
import com.example.trees42.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment: BaseFragment<FragmentHomeBinding>(), HomeContract {

    @Inject
    lateinit var presenter: HomePresenter

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun attachToPresenter() {
        presenter.attachView(this)
    }

    override fun initView() {
        setupBottomNavigationBar()
    }

    private fun setupBottomNavigationBar(){
        val host: NavHostFragment = childFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment? ?: return
        val navController = host.navController
        binding.homeNavigationBar.setupWithNavController(navController)
    }

    companion object{
        fun start(navController: NavController){
            val direction = HomeFragmentDirections.actionToHome()
            navController.navigate(direction)
        }
    }
}