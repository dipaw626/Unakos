package com.mobile.finalprojectbp2.tambah

import android.content.ContentValues
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.mobile.finalprojectbp2.R
import com.mobile.finalprojectbp2.catatan.CatatanActivity
import com.mobile.finalprojectbp2.database.DatabaseHelper
//import com.mobile.finalprojectbp2.detail.AdapterDetail
import java.lang.StringBuilder

class TambahActivity : AppCompatActivity(){

    //all intent
    private lateinit var ivback: ImageView
    private lateinit var rgtambah: RadioGroup
    private lateinit var Pemasukan: RadioButton
    private lateinit var Pengeluaran: RadioButton
    private lateinit var etID: EditText
    private lateinit var etNamein: EditText
    private lateinit var etNominalin: EditText
    private lateinit var etTanggalin: EditText
    private lateinit var etCatatanin: EditText
    private lateinit var ivaddimage: ImageView
    private lateinit var btnSave: Button

    //upload image
    lateinit var  imagebackground: ImageView
    companion object{
        val IMAGE_REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah)

        //hide tittle bar
        supportActionBar?.hide()

        //intent
        ivback = findViewById(R.id.ivBack)
        ivback.setOnClickListener{
            val CatatanBackMain = Intent(this, CatatanActivity::class.java)
            startActivity(CatatanBackMain)
        }

        //instance radio button
        rgtambah = findViewById(R.id.rgTambah)
        Pemasukan = findViewById(R.id.rbTbhPemasukan)
        Pengeluaran = findViewById(R.id.rbTbhPengeluaran)

        //instance upload
        imagebackground = findViewById(R.id.ivTbhBackground)
        etID = findViewById(R.id.etIDTbhIn)
        etNamein = findViewById(R.id.etJudulTbhIn)
        etNominalin = findViewById(R.id.etJmlTbhIn)
        etTanggalin = findViewById(R.id.etTglTbhIn)
        etCatatanin = findViewById(R.id.etTbhNoteIn)
        ivaddimage = findViewById(R.id.ivAddImageTbh)
        btnSave = findViewById(R.id.btnTbhSave)

//        onRadioButtonClicked(Pemasukan)
//        onRadioButtonClicked(Pengeluaran)
    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.rbTbhPengeluaran ->
                    if (checked) {
                        AddPengeluaran()
                        //check
                        Pemasukan.setChecked(false)
                        //enable
                        Pengeluaran.setEnabled(false)
                        Pemasukan.setEnabled(true)
//                        Toast.makeText(this@TambahActivity, "Pengeluaran", Toast.LENGTH_SHORT).show()
                    }
                    else {
                        Pengeluaran.setChecked(false)
                    }
                R.id.rbTbhPemasukan ->
                    if (checked) {
                        AddPemasukan()
                        //check
                        Pengeluaran.setChecked(false)
                        //enable
                        Pemasukan.setEnabled(false)
                        Pengeluaran.setEnabled(true)
//                        Toast.makeText(this@TambahActivity, "Pemasukan", Toast.LENGTH_SHORT).show()
                    }
                    else {
                        Pemasukan.setChecked(false)
                    }
            }
        }
    }

    private fun AddPengeluaran() {
        ivaddimage.setOnClickListener {
            pickImageGalery()
        }

        btnSave.setOnClickListener{
            val databaseHelper = DatabaseHelper(this)
            val id: String = etID.text.toString().trim()
            val name: String = etNamein.text.toString().trim()
            val nominal: Int = etNominalin.text.toString().toInt()
            val note: String = etCatatanin.text.toString().trim()
            val tgl: String = etTanggalin.text.toString().trim()
            val bitmapDrawable: BitmapDrawable = imagebackground.drawable as BitmapDrawable
            val bitmap: Bitmap = bitmapDrawable.bitmap

            val tambahModel = tambahModel(id, name, nominal,tgl, note, bitmap)
            databaseHelper.addTambahPengeluaran(tambahModel)
        }
    }

    private fun AddPemasukan() {
        ivaddimage.setOnClickListener {
            pickImageGalery()
        }

        btnSave.setOnClickListener{
            val databaseHelper = DatabaseHelper(this)
            val id: String = etID.text.toString().trim()
            val name: String = etNamein.text.toString().trim()
            val nominal: Int = etNominalin.text.toString().toInt()
            val note: String = etCatatanin.text.toString().trim()
            val tgl: String = etTanggalin.text.toString().trim()
            val bitmapDrawable: BitmapDrawable = imagebackground.drawable as BitmapDrawable
            val bitmap: Bitmap = bitmapDrawable.bitmap

            val tambahModel = tambahModel(id, name, nominal,tgl, note, bitmap)
            databaseHelper.addTambahPemasukan(tambahModel)
        }
    }

    private fun pickImageGalery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/"
        startActivityForResult(intent, IMAGE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK) {
            imagebackground.setImageURI(data?.data)
        }
    }






}