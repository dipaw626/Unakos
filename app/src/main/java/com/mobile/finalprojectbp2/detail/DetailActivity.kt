package com.mobile.finalprojectbp2.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.mobile.finalprojectbp2.Main.MainActivity
import com.mobile.finalprojectbp2.R
//import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    //all intent
    private lateinit var btnback: Button

    //image
//    lateinit var  image: ImageView
//    companion object{
//        val IMAGE_REQUEST_CODE = 100
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.hide()

        //instance
//        image = findViewById(R.id.ivDetailbukti)
//        val tvName: EditText = findViewById(R.id.tvJudul)
//        val tvNominal: EditText = findViewById(R.id.tvDetailNominal)
//        val tvTanggal: EditText = findViewById(R.id.tvDetailTgl)
//        val tvCatatan: EditText = findViewById(R.id.tvDetailnote)
//        val btnhapus: Button = findViewById(R.id.btnHapus)
//        val ivAddImage: ImageView = findViewById(R.id.ivDetailbukti)
//        val textId: EditText = findViewById(R.id.menuId)

        //event saat iv di klik
//        image.setOnClickListener{
//            pickImageGalery()
//        }

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

//    private fun pickImageGalery() {
//        val intent = Intent(Intent.ACTION_PICK)
//        intent.type = "image/"
//        startActivityForResult(intent, IMAGE_REQUEST_CODE)
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK) {
//            image.setImageURI(data?.data)
//        }
//    }

}