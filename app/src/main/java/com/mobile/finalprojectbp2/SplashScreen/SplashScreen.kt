package com.mobile.finalprojectbp2.SplashScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.MediaController
import com.mobile.finalprojectbp2.Main.MainActivity
import com.mobile.finalprojectbp2.R

class SplashScreen : AppCompatActivity() {

    //declaring a null variable for MediaController
    private val SplashScreenTime: Long = 2000 //2 detik

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        supportActionBar?.hide()

        //assigning id of VideoView from
        //activity_main.xml layout file
        Handler().postDelayed( {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, SplashScreenTime)
    }
}