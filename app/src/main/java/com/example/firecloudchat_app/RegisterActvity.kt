package com.example.firecloudchat_app

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException

class RegisterActvity : AppCompatActivity() {

    lateinit var regFullname:EditText
    lateinit var regEmail:EditText
    lateinit var regPassword:EditText
    lateinit var regCreateAcc:ImageView
    lateinit var text_log:TextView

    //Initialise Firebase
    lateinit var auth: FirebaseAuth
    


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_actvity)

        regFullname = findViewById(R.id.edtfullnamereg)
        regEmail = findViewById(R.id.edtemailreg)
        regPassword = findViewById(R.id.edtpassreg)
        regCreateAcc = findViewById(R.id.btncreateaccount)
        text_log = findViewById(R.id.txtLogin)
        
        auth = FirebaseAuth.getInstance()

        regCreateAcc.setOnClickListener {
            var name = regFullname.text.toString().trim()
            var email = regEmail.text.toString().trim()
            var password = regPassword.text.toString().trim()
            
            //Validate your Input
            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "One of the fields is empty", Toast.LENGTH_SHORT).show()
            } else{
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this){
                    if (it.isSuccessful){
                        Toast.makeText(this, "User Created Successfully", Toast.LENGTH_SHORT).show()

                        var gotologin = Intent(this, LoginAtivity::class.java)
                        startActivity(gotologin)
                    } else{

                        Log.d("TAG", "Error---->", it.exception)

                        Toast.makeText(this, "Failed to Create Account", Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }


        text_log.setOnClickListener {
            var gotologin = Intent(this, LoginAtivity::class.java)
            startActivity(gotologin)
            finish()
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = Color.parseColor("#343434")
        }

    }
}