
package com.mobile.finalprojectbp2.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobile.finalprojectbp2.Fragment.PemasukanFragment
import com.mobile.finalprojectbp2.Fragment.PengeluaranFragment
import com.mobile.finalprojectbp2.R
//import com.mobile.finalprojectbp2.adapter.CatatanAdapter

class CatatanActivity : AppCompatActivity() {

    //fragment
    private lateinit var btnCatatanIn: Button
    private lateinit var  btnCatatanOut: Button

    //all intent
    private lateinit var ivAdd: ImageView
    private lateinit var ivback: ImageView

    //recycler
//    private var layoutManager: RecyclerView.LayoutManager?=null
//    private var adapter: RecyclerView.Adapter<CatatanAdapter.ViewHolder>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catatan)

        //Intent
        ivAdd = findViewById(R.id.ivadd)
        ivAdd.setOnClickListener{
            val CatatanToAdd = Intent(this, TambahActivity::class.java)
            startActivity(CatatanToAdd)
        }

        ivback = findViewById(R.id.ivBack)
        ivback.setOnClickListener{
            val CatatanBackMain = Intent(this, MainActivity::class.java)
            startActivity(CatatanBackMain)
        }

        //fragment aktif
        val OutFragment = PengeluaranFragment()

        //fragment
        btnCatatanIn = findViewById(R.id.btnCttIn)
        btnCatatanOut = findViewById(R.id.btnCttOut)

        btnCatatanOut.setOnClickListener{
            loadFragment(PengeluaranFragment())
        }
        btnCatatanIn.setOnClickListener{
            loadFragment(PemasukanFragment())
        }

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, OutFragment)
            commit()
        }

        //recycler
        //set layout menjadi linear layout
//        layoutManager = LinearLayoutManager(this)

        //instance Recycler View
//        var rvMain: RecyclerView = findViewById(R.id.rvCttIn)

        //setlayout untuk recycler view
//        rvMain.layoutManager = layoutManager

        //call adapter dan set recycler view sesuai adapter yang dibuat
//        adapter = CatatanAdapter()
//        rvMain.adapter = adapter


    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commitNow()
    }


}