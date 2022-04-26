package com.example.loginapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.loginapp.Interface.LoginResultCallBacks
import com.example.loginapp.databinding.ActivityMainBinding
import com.example.loginapp.viewModel.LoginViewModelFactory
import com.example.loginapp.viewModel.ViewModelLogin


class MainActivity : AppCompatActivity(),LoginResultCallBacks {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.view = ViewModelProvider(this, LoginViewModelFactory(this))
            .get(ViewModelLogin::class.java)
        binding.lifecycleOwner = this
    }
    override fun onSuccess(message: String) {
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show()

    }

    override fun onError(message: String) {
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
    }
    }
