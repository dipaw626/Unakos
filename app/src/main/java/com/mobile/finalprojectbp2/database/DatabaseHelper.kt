package com.mobile.finalprojectbp2.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.graphics.Bitmap
import android.widget.Toast
import com.mobile.finalprojectbp2.detail.detailModel
import com.mobile.finalprojectbp2.tambah.tambahModel
import java.io.ByteArrayOutputStream

class DatabaseHelper(var context: Context): SQLiteOpenHelper(
    context,DATABASE_NAME, null,DATABASE_VERSION
) {

    companion object{

        private val DATABASE_NAME = "FP"
        private val DATABASE_VERSION = 1

        //table name 1
        private val TABLE_PEMASUKAN  = "add_pemasukan"
        //column account table
        private val COLUMN_ID_IN = "id_cashIn"
        private val COLUMN_JUDUL_IN = "judul"
        private val COLUMN_NOMINAL_IN = "jumlah"
        private val COLUMN_KETERANGAN_IN = "keterangan"
        private val COLUMN_IMAGE_IN = "bukti_trx"
        private val COLUMN_WAKTU_IN = "waktu"
    }

    //create table pemasukan sql query
    private val CREATE_PEMASUKAN_TABLE = ("CREATE TABLE " + TABLE_PEMASUKAN + "(" + COLUMN_ID_IN + " INT PRIMARY KEY, "
            + COLUMN_JUDUL_IN + " TEXT, " + COLUMN_NOMINAL_IN + " INT, " + COLUMN_KETERANGAN_IN + " TEXT, "
            + COLUMN_IMAGE_IN + " BLOB, " + COLUMN_WAKTU_IN + " TEXT)"
            )

    //drop table menu sql query
    private val DROP_PEMASUKAN_TABLE = "DROP TABLE IF EXISTS $TABLE_PEMASUKAN"


    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL(CREATE_PEMASUKAN_TABLE)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL(DROP_PEMASUKAN_TABLE)
        onCreate(p0)
    }


    //add detailactivity
    fun addDetail(detail:detailModel){
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_ID_IN, detail.id)
        values.put(COLUMN_JUDUL_IN, detail.name)
        values.put(COLUMN_NOMINAL_IN, detail.nominal)
        values.put(COLUMN_KETERANGAN_IN, detail.keterangan)
        values.put(COLUMN_WAKTU_IN, detail.tanggal)
        //prepare image
        val byteOutputStream = ByteArrayOutputStream()
        val imageInByte: ByteArray
        detail.image.compress(Bitmap.CompressFormat.JPEG,100,byteOutputStream)
        imageInByte = byteOutputStream.toByteArray()
        values.put(COLUMN_IMAGE_IN, imageInByte)

        val result = db.insert(TABLE_PEMASUKAN,null,values)
        //show message
        if(result==(0).toLong()) {
            Toast.makeText(context, "Add menu Failed", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(context, "Add menu Success", Toast.LENGTH_SHORT).show()
        }
        db.close()

    }

    //add tambahactivity fragment
    fun addTambah(tambah:tambahModel){
        val db = this.writableDatabase
        val values = ContentValues()
//        values.put(COLUMN_ID_IN, tambah.id)
        values.put(COLUMN_JUDUL_IN, tambah.name)
        values.put(COLUMN_NOMINAL_IN, tambah.nominal)
        values.put(COLUMN_KETERANGAN_IN, tambah.keterangan)
//        values.put(COLUMN_WAKTU_IN, tambah.tanggal)
        //prepare image
        val byteOutputStream = ByteArrayOutputStream()
        val imageInByte: ByteArray
        tambah.image.compress(Bitmap.CompressFormat.JPEG,100,byteOutputStream)
        imageInByte = byteOutputStream.toByteArray()
        values.put(COLUMN_IMAGE_IN, imageInByte)

        val result = db.insert(TABLE_PEMASUKAN,null,values)
        //show message
        if(result==(0).toLong()) {
            Toast.makeText(context, "Add menu Failed", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(context, "Add menu Success", Toast.LENGTH_SHORT).show()
        }
        db.close()

    }




}