package com.mobile.finalprojectbp2.detail

import android.R.attr.description
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.mobile.finalprojectbp2.Main.MainActivity
import com.mobile.finalprojectbp2.R
import com.mobile.finalprojectbp2.catatan.CatatanActivity
import com.mobile.finalprojectbp2.database.DatabaseHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.ByteArrayInputStream


//import kotlin.android.synthetic.detail.detail_activity.*
//import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    //all instance
    private lateinit var btnback: Button
    private lateinit var tvIdin: TextView
    private lateinit var tvIdout: TextView
    private lateinit var tvjudul: TextView
    private lateinit var tvNominal: TextView
    private lateinit var tvTanggal: TextView
    private lateinit var tvCatatan: TextView
    private lateinit var imagedetail: ImageView
    private lateinit var btnhapus: Button

    //
    private var idin: Int = 0
    private var namain: String = ""
    private var idout: Int = 0
    private var namaout: String = ""

    companion object{
        val IMAGE_REQUEST_CODE = 100
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.hide()

        //instance intent
        val btnback = findViewById<Button>(R.id.btnBack)

        //intent
        btnback.setOnClickListener{
            val intent = Intent(this@DetailActivity, CatatanActivity::class.java)
            startActivity(intent)
        }

        //instance
        tvjudul = findViewById(R.id.tvJudul)
        tvNominal = findViewById(R.id.tvDetailNominal)
        tvTanggal = findViewById(R.id.tvDetailTgl)
        tvCatatan = findViewById(R.id.tvDetailnote)
        imagedetail = findViewById(R.id.ivDetailbukti)
        btnhapus = findViewById(R.id.btnHapus)
        tvIdin = findViewById(R.id.tvin)
        tvIdout = findViewById(R.id.tvout)


        //get data gambar dari intent cardview yg diclick
        //pemasukan
        val extras = intent.extras
        if (extras!!.containsKey("COLUMN_ID_IN")) {
            idin = intent.getIntExtra("COLUMN_ID_IN",0)
            namain = intent.getStringExtra("COLUMN_JUDUL_IN").toString()
            var nominalin: Int = intent.getIntExtra("COLUMN_NOMINAL_IN", 0)
            var tanggalin = intent.getStringExtra("COLUMN_WAKTU_IN")
            var catatansin = intent.getStringExtra("COLUMN_KETERANGAN_IN")
            var imagein = intent.getByteArrayExtra("COLUMN_IMAGE_IN") // databasehelper image masi bytearray, convert nya di activity nya.
            //proses tipe image database-user = blob - bytearray - bitmap dan sebaliknya
            //convert image yg dari show di database bentuk bytearray
            val byteInputStream = ByteArrayInputStream(imagein)
            val imagebmp: Bitmap = BitmapFactory.decodeStream(byteInputStream)

            tvjudul.setText(namain)
            tvTanggal.setText(tanggalin)
            tvCatatan.setText(catatansin)
            imagedetail.setImageBitmap(imagebmp)
            tvNominal.setText(""+nominalin)
            tvIdin.setText(""+idin)

            btnhapus.setOnClickListener{
                deleteIn()
            }

        }

        else if (extras!!.containsKey("COLUMN_ID_OUT") && idout != null) {
            idout = intent.getIntExtra("COLUMN_ID_OUT",0)
            namaout = intent.getStringExtra("COLUMN_JUDUL_OUT").toString()
            var nominalout: Int = intent.getIntExtra("COLUMN_NOMINAL_OUT", 0)
            var tanggalout = intent.getStringExtra("COLUMN_WAKTU_OUT")
            var catatansout = intent.getStringExtra("COLUMN_KETERANGAN_OUT")
            var imageout = intent.getByteArrayExtra("COLUMN_IMAGE_OUT") // databasehelper image masi bytearray, convert nya di activity nya.

            //proses tipe image database-user(inputoutstream) = blob - bytearray - bitmap dan sebaliknya
            //convert image yg dari show di database bentuk bytearray
            val byteInputStream = ByteArrayInputStream(imageout)
            val imagebmp: Bitmap = BitmapFactory.decodeStream(byteInputStream)

            tvjudul.setText(namaout)
            tvTanggal.setText(tanggalout)
            tvCatatan.setText(catatansout)
            imagedetail.setImageBitmap(imagebmp)
            tvNominal.setText(""+nominalout)
            tvIdout.setText(""+idout)

            btnhapus.setOnClickListener{
                deleteOut()
            }


        }

        //-------------jan dihapus literasi-----------------
//        Glide.with(this)
//            .load(image)
//            .placeholder(R.drawable.whitefoto)
//            .error(R.drawable.whitefoto) //jk error nampilin ini
//            .into(imagedetail)

//        var imageArray: ByteArray? =intent.getByteArrayExtra("COLUMN_IMAGE_IN")
//        var imagebmp: Bitmap

        //convert bytearray to bitmap
//        val byteInputStream = ByteArrayInputStream(imageArray)
//        imagebmp = BitmapFactory.decodeStream(byteInputStream)
//        imagedetail.setImageBitmap(imagebmp)
//

        //get data dari string intent judul cardview yg diclick
//        var nama = intent.getStringExtra("COLUMN_JUDUL_IN")
//        var nominal = intent.getStringExtra("COLUMN_NOMINAL_IN")
//        var tanggal = intent.getStringExtra("COLUMN_WAKTU_IN")
//        var catatans = intent.getStringExtra("COLUMN_KETERANGAN_IN")

//        Toast.makeText(this, nama.toString(), Toast.LENGTH_SHORT).show()



        //-------------------------SAMPE SINII______________________________


    }


    fun deleteIn() {
        val db = DatabaseHelper(this)
        val dialog = AlertDialog.Builder(this)
        dialog.apply {
            setTitle("Konfirmasi Hapus")
            setMessage("Yakin hapus "+ namain + " ?")
            setNegativeButton("Batal") { dialogInterface, i ->
                dialogInterface.dismiss()
            }
            setPositiveButton("Hapus") { dialogInterface, i ->
                CoroutineScope(Dispatchers.IO).launch {
                    db.deleteIDin(idin.toString())
                    finish()
//                    Toast.makeText(application, "Delete Success ", Toast.LENGTH_SHORT).show()
                    dialogInterface.dismiss()

                }
            }
        }
        dialog.show()
        db.close()
    }

    fun deleteOut() {
        val db = DatabaseHelper(this)
        val dialog = AlertDialog.Builder(this)
        dialog.apply {
            setTitle("Konfirmasi Hapus")
            setMessage("Yakin hapus "+ namaout + " ?")
            setNegativeButton("Batal") { dialogInterface, i ->
                dialogInterface.dismiss()
            }
            setPositiveButton("Hapus") { dialogInterface, i ->
                CoroutineScope(Dispatchers.IO).launch {
                    db.deleteIDout(idout.toString())
                    finish()
//                    Toast.makeText(this, "Delete Success ", Toast.LENGTH_SHORT).show()
                    dialogInterface.dismiss()

                }
            }
        }
        dialog.show()
        db.close()
    }


}




