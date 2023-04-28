package com.example.firecloudchat_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

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

        //Initialise FireBase
        var database = FirebaseDatabase.getInstance()
        var databaseref = database.getReference("cars")


        main_data.setOnClickListener {
            var carmake = main_make.text.toString().trim()
            var carmodel = main_model.text.toString().trim()
            var carprice = main_price.text.toString().trim()

            //Validate EditText
            if (carmake.isEmpty() || carmodel.isEmpty() || carprice.isEmpty()) {
                Toast.makeText(this, "Cannot Submit an Empty Field", Toast.LENGTH_SHORT).show()
            } else{
               //Saving Info to FireBase DataBase

            }

        }

        }
    }
