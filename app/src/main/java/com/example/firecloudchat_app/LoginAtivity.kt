package com.example.firecloudchat_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginAtivity : AppCompatActivity() {

    lateinit var mEmail:EditText
    lateinit var mPassword:EditText
    lateinit var mbtnLogin:Button
    lateinit var mbtnRegister:Button
    
    //Initialise Firebase
    lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_ativity)

        mEmail = findViewById(R.id.edtEmail)
        mPassword = findViewById(R.id.edtPassword)
        mbtnLogin = findViewById(R.id.btnLogin)
        mbtnRegister = findViewById(R.id.btnRegister)
        
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
                        var gotomain = Intent(this, MainActivity::class.java)
                        startActivity(gotomain)
                        finish()
                    } else{
                        Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            
        }

        mbtnRegister.setOnClickListener {

        }


    }
}