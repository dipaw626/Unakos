package com.mobile.finalprojectbp2.Main

import android.annotation.SuppressLint
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
import com.mobile.finalprojectbp2.database.DatabaseHelper
//import com.mobile.finalprojectbp2.catatan.CatatanActivity
import com.mobile.finalprojectbp2.detail.DetailActivity


class MainActivity : AppCompatActivity() {

    //all intent
    private lateinit var ivAdd: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        super.onStart()
        supportActionBar?.hide()

        //Intent
        ivAdd = findViewById(R.id.ivadd)
        ivAdd.setOnClickListener {
            val MainToCatatan = Intent(applicationContext, CatatanActivity::class.java)
            startActivity(MainToCatatan)
        }
        modelAdapterMain()

    }

    private fun modelAdapterMain() {
        val databaseHelper = DatabaseHelper(this)
        val listData = databaseHelper.showMenuPemasukan()

        val mainAdapter = AdapterImage(listData, object : AdapterImage.onAdapterListener {
            @SuppressLint("RestrictedApi")
            override fun onClick(main: MainModel) {
                Log.e("MainActivity", main.toString())
                Toast.makeText(applicationContext, main.nama.toString(), Toast.LENGTH_SHORT).show()

                startActivity(
                    Intent(applicationContext, DetailActivity::class.java)
                        //batas
                        .putExtra("COLUMN_ID_IN", main.id)
                        .putExtra("COLUMN_IMAGE_IN", main.image)
                        .putExtra("COLUMN_JUDUL_IN", main.nama)
                        .putExtra("COLUMN_NOMINAL_IN", main.nominal)
                        .putExtra("COLUMN_WAKTU_IN", main.tanggal)
                        .putExtra("COLUMN_KETERANGAN_IN", main.keterangan)

//                        .putExtra("COLUMN_ID_OUT", main.id)
//                        .putExtra("COLUMN_IMAGE_OUT", main.image)
//                        .putExtra("COLUMN_JUDUL_OUT", main.nama)
//                        .putExtra("COLUMN_NOMINAL_OUT", main.nominal)
//                        .putExtra("COLUMN_WAKTU_OUT", main.tanggal)
//                        .putExtra("COLUMN_KETERANGAN_OUT", main.keterangan)

                )
            }

//            override fun onDelete(main: MainModel) {
//                deleteDatabase("COLUMN_ID_IN")
//            }

//            override fun onUpdate(main: MainModel) {
//                intenEdit()
//            }
        })
        findViewById<RecyclerView>(R.id.rvLastActivity).apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = mainAdapter
        }

    }

}

//    private fun modelAdapterMainPengeluaran() {
//        val databaseHelper = DatabaseHelper(this)
//        val listData = databaseHelper.showMenuPengeluaran()
//
//        val catatanAdapter = AdapterImage(listData, object : AdapterImage.onAdapterListener {
//            override fun onClick(catatan: MainModel) {
//                Log.e("CatatanActivity", catatan.toString())
//                Toast.makeText(applicationContext, catatan.nama.toString(), Toast.LENGTH_SHORT).show()
//
//
//                startActivity(
//                    Intent(applicationContext, DetailActivity::class.java)
//                        .putExtra("COLUMN_ID_OUT", catatan.id)
//                        .putExtra("COLUMN_IMAGE_OUT", catatan.image)
//                        .putExtra("COLUMN_JUDUL_OUT", catatan.nama)
//                        .putExtra("COLUMN_NOMINAL_OUT", catatan.nominal)
//                        .putExtra("COLUMN_WAKTU_OUT", catatan.tanggal)
//                        .putExtra("COLUMN_KETERANGAN_OUT", catatan.keterangan)
//
//
//                )
//            }
//        })
//        findViewById<RecyclerView>(R.id.rvCatatan).apply {
//            layoutManager = LinearLayoutManager(this@MainActivity)
//            adapter = catatanAdapter
//        }
//
//    }


//    private fun getDataFromApi() {
//        ProgressBar.visibility = View.VISIBLE
//        ApiService.endpoint.getData()
//            .enqueue(object : Callback<MainModel> {
//                override fun onFailure(call: Call<MainModel>, t:Throwable) {
//                    ProgressBar.visibility = View.GONE
//                    printlog( "onFailure: $t" )
//                }
//
//                override fun onResponse(
//                    call: Call<MainModel>,
//                    response: Response<MainModel>
//                ) {
//                    ProgressBar.visibility = View.GONE
//                    if (response.isSuccessful) {
//                        showData(response.body()!!)
//                    }
//                }
//            })
//    }
//
//    private fun printlog(message: String) {
//        Log.d(Tag, message)
//    }


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
