package com.mobile.finalprojectbp2.Main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobile.finalprojectbp2.R
import com.mobile.finalprojectbp2.catatan.CatatanActivity
import com.mobile.finalprojectbp2.detail.DetailActivity


class MainActivity : AppCompatActivity() {

    //recycler
//    private var layoutManager: RecyclerView.LayoutManager? = null
//    private var adapter: RecyclerView.Adapter<MainAdapter.ViewHolder>?=null

    //all intent
    private lateinit var ivAdd: ImageView
//    private lateinit var rvlastactivity: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Intent
        ivAdd = findViewById(R.id.ivadd)
        ivAdd.setOnClickListener {
            val MainToCatatan = Intent(applicationContext, CatatanActivity::class.java)
            startActivity(MainToCatatan)
        }


//        //set layout menjadi linear layout
//        layoutManager = LinearLayoutManager(this)
//
//        //instance Recycler View
//        var rvMain:RecyclerView = findViewById(R.id.rvLastActivity)
//
//        //setlayout untuk recycler view
//        rvMain.layoutManager = layoutManager
//
//        //call adapter dan set recycler view sesuai adapter yang dibuat
//        adapter = MainAdapter()
//        rvMain.adapter = adapter


        modelAdapterMain()


    }

    private fun modelAdapterMain() {
        val mains = listOf<MainModel>(
            MainModel(
                1,
                R.drawable.document_signed,
                "Seragam Organisasi",
                "- Rp150.000",
                "Januari 10 2022"
            ),
            MainModel(
                2,
                R.drawable.document_signed,
                "Makan Bulanan",
                "- Rp350.000",
                "Februari 10 2022"
            ),
            MainModel(3, R.drawable.document_signed, "Gaji", "Rp10.000.000", "Maret 10 2022"),
            MainModel(4, R.drawable.document_signed, "Qurban", "Rp3.000.000", "April 10 2022"),
        )
        val mainAdapter = AdapterImage(mains, object : AdapterImage.onAdapterListener {
            override fun onClick(main: MainModel) {
                Log.e("MainActivity", main.toString())
                Toast.makeText(applicationContext, main.nama.toString(), Toast.LENGTH_SHORT).show()

                startActivity(
                    Intent(applicationContext, DetailActivity::class.java)
                        .putExtra("tvJudul", main.nama)
                        .putExtra("intent_nominal", main.nominal)
                        .putExtra("intent_tanggal", main.tanggal)
//                        .putExtra("intent_image", main.)

                )
            }

        })
        findViewById<RecyclerView>(R.id.rvLastActivity).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mainAdapter
        }

    }


}

//    private fun imageAdapter() {
//
//        val foto = listOf<Int>(
//            R.drawable.document_signed,
//            R.drawable.document_signed,
//            R.drawable.document_signed,
//            R.drawable.document_signed
//        )
//
//        val fotoAdapter = AdapterImage(foto)
//
//
////        findViewById<RecyclerView>(R.id.rvLastActivity).layoutManager = LinearLayoutManager(this)
////        findViewById<RecyclerView>(R.id.rvLastActivity).adapter = fotoAdapter
////        findViewById<RecyclerView>(R.id.rvLastActivity).adapter = namaAdapter
////        findViewById<RecyclerView>(R.id.rvLastActivity).adapter = jumlahAdapter
////        findViewById<RecyclerView>(R.id.rvLastActivity).adapter = tglAdapter
//
//        findViewById<RecyclerView>(R.id.rvLastActivity).apply {
//            layoutManager = LinearLayoutManager(this@MainActivity)
//            adapter = fotoAdapter
//        }
//
//    }

//    private  fun textAdapter() {
//        val nama = listOf<String>(
//            "Seragam Organisasi",
//            "Makan Bulanan",
//            "Gaji",
//            "Qurban"
//        )
//        val tgl = listOf<String>(
//            "April 15 2022",
//            "April 10 2022",
//            "April 5 2022",
//            "Mei 1 2022"
//        )
//
//        val jumlah = listOf<String>(
//            "- Rp150.000",
//            "- Rp350.000",
//            "Rp10.000.000",
//            "Rp3.000.000"
//        )
//
//        Log.e("MainActivity", "size ${nama.size}")
//        Log.e("MainActivity", nama[1])
//        nama.forEach{ nama ->
//            Log.e("MainActivity", nama)
//        }
////
////        Log.e("MainActivity", "size ${jumlah.size}")
////        Log.e("MainActivity", jumlah[1])
////        nama.forEach{ jumlah ->
////            Log.e("MainActivity", jumlah)
////        }
//
//        val namaAdapter = AdapterText(nama, object : AdapterText.OnAdapterListener {
//            override fun onClick(nama: String) {
//                Toast.makeText(applicationContext, "message", Toast.LENGTH_SHORT).show()
//            }
//        })
//        val jumlahAdapter = AdapterText(jumlah)
//        val tglAdapter = AdapterText(tgl)
//
//        findViewById<RecyclerView>(R.id.rvLastActivity).apply {
//            layoutManager = LinearLayoutManager(this@MainActivity)
//            adapter = namaAdapter
//            adapter = jumlahAdapter
//            adapter = tglAdapter
//        }
//
//
//    }



//    private fun populateHistory() {
//        val history1 = history(
//            R.drawable.document_signed,
//            "Seragam Organisasi",
//            "April 15 2022",
//            "- Rp150.000"
//        )
//        historyList.add(history1)
//
//        val history2 = history(
//            R.drawable.document_signed,
//            "Makan Bulanan",
//            "April 20 2022",
//            "- Rp500.000"
//        )
//        historyList.add(history2)
//
//        val history3 = history(
//            R.drawable.document_signed,
//            "Bonus Gaji",
//            "April 29 2022",
//            "Rp4.000.000"
//        )
//        historyList.add(history3)
//
//        val history4 = history(
//            R.drawable.document_signed,
//            "sedekah",
//            "April 15 2022",
//            "- Rp1.500.000"
//        )
//        historyList.add(history4)
//
//        historyList.add(history1)
//        historyList.add(history2)
//        historyList.add(history3)
//        historyList.add(history4)
//
//    }

//    override fun onClick(History: MainAdapter) {
//        val intent = Intent(applicationContext, DetailActivity::class.java)
////        intent.putExtra(HISTORY_ID_EXTRA, History.id)
//        startActivity(intent)
//    }


//beda
