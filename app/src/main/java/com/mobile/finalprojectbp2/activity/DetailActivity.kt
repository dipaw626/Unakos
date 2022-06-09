package com.mobile.finalprojectbp2.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.mobile.finalprojectbp2.R

class DetailActivity : AppCompatActivity() {

    //all intent
    private lateinit var btnback: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //intent
        btnback = findViewById(R.id.btnBack)
        btnback.setOnClickListener{
            val DetailBackMain = Intent(this, MainActivity::class.java)
            startActivity(DetailBackMain)
        }

    }
}