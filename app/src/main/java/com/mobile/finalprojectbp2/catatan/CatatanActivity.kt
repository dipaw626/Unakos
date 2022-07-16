
package com.mobile.finalprojectbp2.catatan

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobile.finalprojectbp2.Main.AdapterImage
import com.mobile.finalprojectbp2.Main.MainActivity
import com.mobile.finalprojectbp2.Main.MainModel
import com.mobile.finalprojectbp2.R
import com.mobile.finalprojectbp2.database.DatabaseHelper
import com.mobile.finalprojectbp2.detail.DetailActivity
import com.mobile.finalprojectbp2.tambah.TambahActivity



class CatatanActivity : AppCompatActivity() {


    //all intent
    private lateinit var ivback: ImageView
    private lateinit var imagedetail: ImageView
    private lateinit var gambar: ByteArray

    private lateinit var Pemasukan: RadioButton
    private lateinit var Pengeluaran: RadioButton
    private lateinit var rgcatatan: RadioGroup



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catatan)

        supportActionBar?.hide()

        //Intent
        val ivAdd = findViewById<ImageView>(R.id.ivadd)
        ivAdd.setOnClickListener{
            val CatatanToAdd = Intent(applicationContext, TambahActivity::class.java)
            startActivity(CatatanToAdd)
        }

        ivback = findViewById(R.id.ivBack)
        ivback.setOnClickListener{
            val CatatanBackMain = Intent(applicationContext, MainActivity::class.java)
            startActivity(CatatanBackMain)
        }

        //instance radio button
        rgcatatan = findViewById(R.id.rgCatatan)
        Pemasukan = findViewById(R.id.rbCttIn)
        Pengeluaran = findViewById(R.id.rbCttOut)

//        onRadioButtonClicked(Pemasukan)
//        onRadioButtonClicked(Pengeluaran)
//        Toast.makeText(applicationContext, Pemasukan, Toast.LENGTH_SHORT).show()
    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.rbCttOut ->
                    if (checked) {
                        modelAdapterCatatanPengeluaran()
                        //check
                        Pemasukan.setChecked(false)
                        //enable
                        Pengeluaran.setEnabled(false)
                        Pemasukan.setEnabled(true)
//                        Toast.makeText(this@CatatanActivity, "Pengeluaran", Toast.LENGTH_SHORT).show()
                    }
                    else {
                        Pengeluaran.setChecked(false)
                    }
                R.id.rbCttIn ->
                    if (checked) {
                        modelAdapterCatatanPemasukan()
                        //check
                        Pengeluaran.setChecked(false)
                        //enable
                        Pemasukan.setEnabled(false)
                        Pengeluaran.setEnabled(true)
//                        Toast.makeText(this@CatatanActivity, "Pemasukan", Toast.LENGTH_SHORT).show()
                    }
                    else {
                        Pemasukan.setChecked(false)
                    }
            }
        }
    }

//    private fun toggleCheck(){
//        if (Pengeluaran.isChecked()) {
//            Pemasukan.setChecked(false)
//            if (Pemasukan.isChecked == true) {
//                Pemasukan.setChecked(false)
//            }
//                Pengeluaran.setEnabled(false)
//                Pemasukan.setEnabled(true)
//        }
//        if (Pemasukan.isChecked()) {
//            Pengeluaran.setChecked(false)
//            if (Pengeluaran.isChecked == true){
//                Pengeluaran.setChecked(false)
//            Pemasukan.setEnabled(false)
//            Pengeluaran.setEnabled(true)
//            }
//        }
//    }


    private fun modelAdapterCatatanPengeluaran() {
        val databaseHelper = DatabaseHelper(this)
        val listData = databaseHelper.showMenuPengeluaran()

        val catatanAdapter = AdapterImage(listData, object : AdapterImage.onAdapterListener {
            override fun onClick(catatan: MainModel) {
                Log.e("CatatanActivity", catatan.toString())
                Toast.makeText(applicationContext, catatan.nama.toString(), Toast.LENGTH_SHORT).show()


                startActivity(
                    Intent(applicationContext, DetailActivity::class.java)
                        .putExtra("COLUMN_ID_OUT", catatan.id)
                        .putExtra("COLUMN_IMAGE_OUT", catatan.image)
                        .putExtra("COLUMN_JUDUL_OUT", catatan.nama)
                        .putExtra("COLUMN_NOMINAL_OUT", catatan.nominal)
                        .putExtra("COLUMN_WAKTU_OUT", catatan.tanggal)
                        .putExtra("COLUMN_KETERANGAN_OUT", catatan.keterangan)


                )
            }
        })
        findViewById<RecyclerView>(R.id.rvCatatan).apply {
            layoutManager = LinearLayoutManager(this@CatatanActivity)
            adapter = catatanAdapter
        }

    }

    private fun modelAdapterCatatanPemasukan() {
        val databaseHelper = DatabaseHelper(this)
        val listData = databaseHelper.showMenuPemasukan()

        val catatanAdapter = AdapterImage(listData, object : AdapterImage.onAdapterListener {
            override fun onClick(catatan: MainModel) {
                Log.e("CatatanActivity", catatan.toString())
                Toast.makeText(applicationContext, catatan.nama.toString(), Toast.LENGTH_SHORT).show()

                startActivity(
                    Intent(applicationContext, DetailActivity::class.java)
                        .putExtra("COLUMN_ID_IN", catatan.id)
                        .putExtra("COLUMN_IMAGE_IN", catatan.image)
                        .putExtra("COLUMN_JUDUL_IN", catatan.nama)
                        .putExtra("COLUMN_NOMINAL_IN", catatan.nominal)
                        .putExtra("COLUMN_WAKTU_IN", catatan.tanggal)
                        .putExtra("COLUMN_KETERANGAN_IN", catatan.keterangan)
                )
            }
        })
        findViewById<RecyclerView>(R.id.rvCatatan).apply {
            layoutManager = LinearLayoutManager(this@CatatanActivity)
            adapter = catatanAdapter
        }

    }


}