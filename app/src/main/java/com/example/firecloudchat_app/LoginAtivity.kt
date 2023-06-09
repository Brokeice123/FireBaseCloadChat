package com.example.firecloudchat_app

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Build
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import androidx.core.graphics.ColorUtils
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView

class LoginAtivity : AppCompatActivity() {

    lateinit var mEmail:EditText
    lateinit var mPassword:EditText
    lateinit var mbtnLogin:ImageView
    lateinit var mRegister:TextView
    
    //Initialise Firebase
    lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_ativity)

        mEmail = findViewById(R.id.edtEmail)
        mPassword = findViewById(R.id.edtPassword)
        mbtnLogin = findViewById(R.id.btnlogin)
        mRegister = findViewById(R.id.txtReg)

        
        auth = FirebaseAuth.getInstance()

        mbtnLogin.setOnClickListener {
            var email = mEmail.text.toString().trim()
            var password = mPassword.text.toString().trim()

            //Validate Input
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "One of the inputs is empty", Toast.LENGTH_SHORT).show()
            } else{
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this) {
                    if (it.isSuccessful){
                        Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                        var gotomain = Intent(this, Video_SplashActivity::class.java)
                        startActivity(gotomain)
                        finish()
                    } else{
                        Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
                    }
                }
            }


        }

        mRegister.setOnClickListener {
            var gotoregister = Intent(this, RegisterActvity::class.java)
            startActivity(gotoregister)
            finish()
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = Color.parseColor("#343434")
        }




    }
}