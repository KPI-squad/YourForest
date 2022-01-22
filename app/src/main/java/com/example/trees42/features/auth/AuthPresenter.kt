package com.example.trees42.features.auth

import android.widget.Toast
import com.example.trees42.app.DBConfig
import com.example.trees42.base.BasePresenter
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import javax.inject.Inject

class AuthPresenter @Inject constructor(): BasePresenter<AuthContract>() {

    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onViewAttached() {
        if(rootView == null ) {
            return
        }

        val context = (rootView as AuthFragment).requireContext()
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("158062157635-45nvjnvrodq1tmvu68tum7hbrao67co6.apps.googleusercontent.com")
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(context, gso)
    }

    fun onGoogleLoginCLicked(){
        val signInIntent = googleSignInClient.signInIntent
        (rootView as AuthFragment).startActivityForResult(signInIntent, DBConfig.GOOGLE_SIGN_IN_CODE_REQUEST)
        rootView?.startHomeFragment()
    }
}