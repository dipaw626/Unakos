package com.mobile.finalprojectbp2.tambah

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.mobile.finalprojectbp2.R
import com.mobile.finalprojectbp2.catatan.CatatanActivity

class TambahActivity : AppCompatActivity() {

    //all intent
    private lateinit var ivback: ImageView

    //fragment
    private lateinit var btntmbhout: Button
    private lateinit var btntmbhin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah)

        supportActionBar?.hide()

        //intent
        ivback = findViewById(R.id.ivBack)
        ivback.setOnClickListener{
            val CatatanBackMain = Intent(this, CatatanActivity::class.java)
            startActivity(CatatanBackMain)
        }

        //fragment aktif
        val OutFragment = TambahPengeluaranFr()

        //fragment
        btntmbhout = findViewById(R.id.btntmbhOut)
        btntmbhin = findViewById(R.id.btntmbhIn)

        btntmbhin.setOnClickListener{
            loadFragment(TambahPemasukanFr())
        }
        btntmbhout.setOnClickListener{
            loadFragment(TambahPengeluaranFr())
        }

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.tambahcontainer, OutFragment)
            commit()
        }


    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.tambahcontainer, fragment)
            .commitNow()
    }

}