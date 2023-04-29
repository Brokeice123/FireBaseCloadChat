package com.example.firecloudchat_app

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SplashScreen : AppCompatActivity() {

    lateinit var spbtnlog:TextView
    lateinit var spbtnreg:TextView

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

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = Color.parseColor("#343434")
        }

    }
}