package com.mobile.finalprojectbp2.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.mobile.finalprojectbp2.Main.MainActivity
import com.mobile.finalprojectbp2.R
//import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    //all intent
    private lateinit var btnback: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //get data dari string intent judul cardview yg diclick
//        supportActionBar!!.title = intent.getStringExtra("tvJudul")


        //get data gambar dari intent cardview yg diclick
//        Glide.with(this)
//            .load(intent.getStringExtra("intent_image"))
//            .placeholder(R.drawable.im_calendar)
//            .error(R.drawable.im_calendar)
//            .into( imageView )



        //intent
        btnback = findViewById(R.id.btnBack)
        btnback.setOnClickListener{
            val DetailBackMain = Intent(this, MainActivity::class.java)
            startActivity(DetailBackMain)
        }

    }
}