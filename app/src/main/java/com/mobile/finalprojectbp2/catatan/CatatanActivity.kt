
package com.mobile.finalprojectbp2.catatan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.mobile.finalprojectbp2.Main.MainActivity
import com.mobile.finalprojectbp2.R

//import com.mobile.finalprojectbp2.adapter.CatatanAdapter

class CatatanActivity : AppCompatActivity() {

    //fragment
    private lateinit var btnCatatanIn: Button
    private lateinit var  btnCatatanOut: Button

    //all intent
//    private lateinit var ivAdd: ImageView
    private lateinit var ivback: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catatan)

        //Intent
//        ivAdd = findViewById(R.id.ivadd)
//        ivAdd.setOnClickListener{
//            val CatatanToAdd = Intent(this, TambahActivity::class.java)
//            startActivity(CatatanToAdd)
//        }

        ivback = findViewById(R.id.ivBack)
        ivback.setOnClickListener{
            val CatatanBackMain = Intent(this, MainActivity::class.java)
            startActivity(CatatanBackMain)
        }

        //fragment aktif
        val OutFragment = CttPengeluaranFr()

        //fragment
        btnCatatanIn = findViewById(R.id.btnCttIn)
        btnCatatanOut = findViewById(R.id.btnCttOut)

        btnCatatanOut.setOnClickListener{
            loadFragment(CttPengeluaranFr())
        }
        btnCatatanIn.setOnClickListener{
            loadFragment(CttPemasukanFr())
        }

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.cttcontainer, OutFragment)
            commit()
        }

    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.cttcontainer, fragment)
            .commitNow()
    }




}