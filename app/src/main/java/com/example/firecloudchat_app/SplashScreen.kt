package com.example.firecloudchat_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SplashScreen : AppCompatActivity() {

    lateinit var spbtnlog:Button
    lateinit var spbtnreg:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        spbtnlog = findViewById(R.id.splashbtnlogin)
        spbtnreg = findViewById(R.id.splashbtnreg)

        spbtnlog.setOnClickListener {
            var gotologin = Intent(this, LoginAtivity::class.java)
            startActivity(gotologin)
            finish()
        }

        spbtnreg.setOnClickListener {
            var gotoregister = Intent(this, RegisterActvity::class.java)
            startActivity(gotoregister)
            finish()
        }

    }
}