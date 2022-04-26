package com.example.loginapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.loginapp.Interface.LoginResultCallBacks

class LoginViewModelFactory(private val listener: LoginResultCallBacks):ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ViewModelLogin(listener) as T
    }
}