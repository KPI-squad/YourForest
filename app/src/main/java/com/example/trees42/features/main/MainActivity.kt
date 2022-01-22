package com.example.trees42.features.main

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import com.example.trees42.R
import com.example.trees42.app.DBConfig
import com.example.trees42.base.BaseActivity
import com.example.trees42.databinding.ActivityMainBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(){

    override fun createViewBinding(inflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(inflater)
    }
}