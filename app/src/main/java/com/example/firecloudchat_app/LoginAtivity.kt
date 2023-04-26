package com.example.firecloudchat_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LoginAtivity : AppCompatActivity() {

    lateinit var mEmail:EditText
    lateinit var mPassword:EditText
    lateinit var mbtnLogin:Button
    lateinit var mbtnRegister:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_ativity)

        mEmail = findViewById(R.id.edtEmail)
        mPassword = findViewById(R.id.edtPassword)
        mbtnLogin = findViewById(R.id.btnLogin)
        mbtnRegister = findViewById(R.id.btnRegister)

        mbtnLogin.setOnClickListener {

        }

        mbtnRegister.setOnClickListener {

        }


    }
}