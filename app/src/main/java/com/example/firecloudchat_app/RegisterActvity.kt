package com.example.firecloudchat_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class RegisterActvity : AppCompatActivity() {

    lateinit var regFullname:EditText
    lateinit var regEmail:EditText
    lateinit var regPassword:EditText
    lateinit var regCreateAcc:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_actvity)

        regFullname = findViewById(R.id.edtfullnamereg)
        regEmail = findViewById(R.id.edtemailreg)
        regPassword = findViewById(R.id.edtpassreg)
        regCreateAcc = findViewById(R.id.btncreateaccount)

        regCreateAcc.setOnClickListener {

        }


    }
}