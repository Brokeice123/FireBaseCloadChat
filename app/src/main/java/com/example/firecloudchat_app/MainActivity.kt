package com.example.firecloudchat_app

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    lateinit var main_make:EditText
    lateinit var main_model:EditText
    lateinit var main_price:EditText
    lateinit var imageView:ImageView

    lateinit var main_photo:TextView
    lateinit var main_data:TextView
    lateinit var main_view:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_make = findViewById(R.id.Edtcarmake)
        main_model = findViewById(R.id.edtcarmodel)
        main_price = findViewById(R.id.edtcarprice)

        main_photo = findViewById(R.id.btn_photo)
        imageView = findViewById(R.id.image_view)
        main_data = findViewById(R.id.btn_data)
        main_view = findViewById(R.id.btn_view)

        //Initialise FireBase
        var database = FirebaseDatabase.getInstance()
        var databaseref = database.getReference("cars")


        main_data.setOnClickListener {
            var carmake = main_make.text.toString().trim()
            var carmodel = main_model.text.toString().trim()
            var carprice = main_price.text.toString().trim()
            var carphoto = imageView.toString()

            //Validate EditText
            if (carmake.isEmpty() || carmodel.isEmpty() || carprice.isEmpty() || carphoto.isEmpty()) {
                Toast.makeText(this, "Cannot Submit an Empty Field", Toast.LENGTH_SHORT).show()
            } else{
               //Saving Info to FireBase DataBase
                var usercar = Car(carmake,carmodel,carprice,carphoto)
                
                var ref = FirebaseDatabase.getInstance().getReference().child("cars")
                
                ref.setValue(usercar).addOnCompleteListener { 
                    
                    if (it.isSuccessful) {
                        Toast.makeText(this, "Car Data Uploaded Successfully", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Failed to save Car Data", Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }

        main_photo.setOnClickListener {
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { intent ->
                intent.resolveActivity(packageManager)?.also {
                    startActivityForResult(intent, REQUEST_IMAGE_CAPTURE)
                }
            }
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = Color.parseColor("#343434")
        }

        }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            imageView.setImageBitmap(imageBitmap)
        }
    }

    companion object {
        const val REQUEST_IMAGE_CAPTURE = 1
    }

    }
