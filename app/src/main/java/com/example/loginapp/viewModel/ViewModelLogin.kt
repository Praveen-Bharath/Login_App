package com.example.loginapp.viewModel

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.ViewModel
import com.example.loginapp.Interface.LoginResultCallBacks
import com.example.loginapp.Model.ModelLogin


class ViewModelLogin(private val listener: LoginResultCallBacks):ViewModel(){

        private val user: ModelLogin

        init {
            this.user = ModelLogin("","")
        }

    val emailTextWatcher : TextWatcher

         get() =  object : TextWatcher{
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun afterTextChanged(p0: Editable?) {
                        user.setEmail(p0.toString())
                }

        }

        val passwordTextWatcher : TextWatcher
         get() =  object : TextWatcher{
                        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                        }

                        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                        }

                        override fun afterTextChanged(p0: Editable?) {
                                user.setPassword(p0.toString())
                        }

                }

        fun onClicked(v:View){
            var code: Int = user.isDataValid()
                if(code ==0 )
                        listener.onError("Email should not be empty")
                else if (code ==1)
                        listener.onError("Wrong email pattern")
                else if (code == 2)
                        listener.onError("Password length must greater than 6")
                else
                        listener.onSuccess("Login Success")
        }
}