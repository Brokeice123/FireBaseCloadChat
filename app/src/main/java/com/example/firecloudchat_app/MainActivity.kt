package com.example.firecloudchat_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var main_make:EditText
    lateinit var main_model:EditText
    lateinit var main_price:EditText
    lateinit var main_photo:Button
    lateinit var main_data:Button
    lateinit var main_view:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_make = findViewById(R.id.Edtcarmake)
        main_model = findViewById(R.id.edtcarmodel)
        main_price = findViewById(R.id.edtcarprice)
        main_photo = findViewById(R.id.btn_photo)
        main_data = findViewById(R.id.btn_data)
        main_view = findViewById(R.id.btn_view)





        }


    }
