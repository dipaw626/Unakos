package com.mobile.finalprojectbp2.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AbsListView
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobile.finalprojectbp2.R
import com.mobile.finalprojectbp2.adapter.MainAdapter

class MainActivity : AppCompatActivity() {

    //recycler
    private var layoutManager: RecyclerView.LayoutManager?=null
    private var adapter: RecyclerView.Adapter<MainAdapter.ViewHolder>?=null

    //all intent
    private lateinit var ivAdd: ImageView
//    private lateinit var rvlastactivity: RecyclerView
//    private lateinit var cvmain: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Intent
        ivAdd = findViewById(R.id.ivadd)
        ivAdd.setOnClickListener{
            val MainToCatatan = Intent(this, CatatanActivity::class.java)
            startActivity(MainToCatatan)
        }

//        rvlastactivity = findViewById(R.id.rvLastActivity)
//        rvlastactivity.setOnClickListener{
//            val historyitemTodetail = Intent(this, DetailActivity::class.java)
//            startActivity(historyitemTodetail)
//        }

//        cvmain = findViewById(R.id.cvMain)
//        cvmain.setOnClickListener{
//            val historyitemTodetail = Intent(this, DetailActivity::class.java)
//            startActivity(historyitemTodetail)
//        }

        //set layout menjadi linear layout
        layoutManager = LinearLayoutManager(this)

        //instance Recycler View
        var rvMain:RecyclerView = findViewById(R.id.rvLastActivity)

        //setlayout untuk recycler view
        rvMain.layoutManager = layoutManager

        //call adapter dan set recycler view sesuai adapter yang dibuat
        adapter = MainAdapter()
        rvMain.adapter = adapter
    }
}