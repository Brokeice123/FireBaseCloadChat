package com.example.firecloudchat_app

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.VideoView

class Video_SplashActivity : AppCompatActivity() {

    private lateinit var videoView: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_splash)

        videoView = findViewById(R.id.logo)

        val videoUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.my_video)
        videoView.setVideoURI(videoUri)
        videoView.start()

        Handler().postDelayed({
            videoView.stopPlayback()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 7000)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = Color.parseColor("#000000")
        }

    }
}