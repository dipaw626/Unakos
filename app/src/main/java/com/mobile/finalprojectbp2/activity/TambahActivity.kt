package com.mobile.finalprojectbp2.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.mobile.finalprojectbp2.R

class TambahActivity : AppCompatActivity() {

    //all intent
    private lateinit var ivback: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah)

        //intent
        ivback = findViewById(R.id.ivBack)
        ivback.setOnClickListener{
            val CatatanBackMain = Intent(this, CatatanActivity::class.java)
            startActivity(CatatanBackMain)
        }


    }
}