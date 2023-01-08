package com.mobile.finalprojectbp2.database

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.database.CursorWindow
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import android.graphics.Bitmap
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.mobile.finalprojectbp2.Main.MainModel
import com.mobile.finalprojectbp2.catatan.CatatanActivity
import com.mobile.finalprojectbp2.tambah.tambahModel
import java.io.ByteArrayOutputStream
import java.lang.reflect.Field

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
        val COLUMN_IMAGE_IN = "bukti_trx"
        private val COLUMN_WAKTU_IN = "waktu"

//        //table name 2
        private val TABLE_PENGELUARAN  = "add_pengeluaran"
        //column account table
        private val COLUMN_ID_OUT = "id_cashOut"
        private val COLUMN_JUDUL_OUT = "judul"
        private val COLUMN_NOMINAL_OUT = "jumlah"
        private val COLUMN_KETERANGAN_OUT = "keterangan"
        private val COLUMN_IMAGE_OUT = "bukti_trx"
        private val COLUMN_WAKTU_OUT = "waktu"
//
//        //table name 3
//        private val TABLE_INFO  = "infoTerakhir"
//        //column account table
//        private val COLUMN_ID_INFO = "id_lastInfo"
//        private val COLUMN_ID_OUT = "id_cashOut"
//        private val COLUMN_ID_IN = "id_cashIn"
//        private val COLUMN_AKTIVITAS = "waktu_aktivitas"

    }

    //create table pemasukan sql query
    private val CREATE_PEMASUKAN_TABLE = ("CREATE TABLE " + TABLE_PEMASUKAN + "(" + COLUMN_ID_IN + " INT PRIMARY KEY, "
            + COLUMN_JUDUL_IN + " TEXT, " + COLUMN_NOMINAL_IN + " INT, " + COLUMN_KETERANGAN_IN + " TEXT, "
            + COLUMN_IMAGE_IN + " BLOB, " + COLUMN_WAKTU_IN + " TEXT)"
            )

//    private val DELETE_PEMASUKAN_TABLE = ("DELETE *FROM " + TABLE_PEMASUKAN + "where COLUMN_ID_IN = " + COLUMN_ID_IN )

    //drop table menu sql query
    private val DROP_PEMASUKAN_TABLE = "DROP TABLE IF EXISTS $TABLE_PEMASUKAN"

    //create table pengeluaran sql query
    private val CREATE_PENGELUARAN_TABLE = ("CREATE TABLE " + TABLE_PENGELUARAN + "(" + COLUMN_ID_OUT + " INT PRIMARY KEY, "
            + COLUMN_JUDUL_OUT + " TEXT, " + COLUMN_NOMINAL_OUT + " INT, " + COLUMN_KETERANGAN_OUT + " TEXT, "
            + COLUMN_IMAGE_OUT + " BLOB, " + COLUMN_WAKTU_OUT + " TEXT)"
            )

    //drop table menu sql query
    private val DROP_PENGELUARAN_TABLE = "DROP TABLE IF EXISTS $TABLE_PENGELUARAN"

    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL(CREATE_PEMASUKAN_TABLE)
        p0?.execSQL(CREATE_PENGELUARAN_TABLE)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL(DROP_PEMASUKAN_TABLE)
//        p0?.execSQL(DELETE_PEMASUKAN_TABLE)
        p0?.execSQL(DROP_PENGELUARAN_TABLE)
        onCreate(p0)
    }


    //add detailactivity
//    fun addDetail(detail:detailModel){
//        val db = this.writableDatabase
//        val values = ContentValues()
//        values.put(COLUMN_ID_IN, detail.id)
//        values.put(COLUMN_JUDUL_IN, detail.name)
//        values.put(COLUMN_NOMINAL_IN, detail.nominal)
//        values.put(COLUMN_KETERANGAN_IN, detail.keterangan)
//        values.put(COLUMN_WAKTU_IN, detail.tanggal)
//        //prepare image
//        val byteOutputStream = ByteArrayOutputStream()
//        val imageInByte: ByteArray
//        detail.image.compress(Bitmap.CompressFormat.JPEG,100,byteOutputStream)
//        imageInByte = byteOutputStream.toByteArray()
//        values.put(COLUMN_IMAGE_IN, imageInByte)
//
//        val result = db.insert(TABLE_PEMASUKAN,null,values)
//        //show message
//        if(result==(0).toLong()) {
//            Toast.makeText(context, "Add menu Failed", Toast.LENGTH_SHORT).show()
//        }
//        else{
//            Toast.makeText(context, "Add menu Success", Toast.LENGTH_SHORT).show()
//        }
//        db.close()
//
//    }

    //add tambahactivity fragment
    fun addTambahPemasukan(tambah:tambahModel){
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_ID_IN, tambah.id)
        values.put(COLUMN_JUDUL_IN, tambah.name)
        values.put(COLUMN_NOMINAL_IN, tambah.nominal)
        values.put(COLUMN_WAKTU_IN, tambah.tanggal)
        values.put(COLUMN_KETERANGAN_IN, tambah.keterangan)

        //prepare image
        val byteOutputStream = ByteArrayOutputStream()
        val imageInByte: ByteArray
        tambah.image.compress(Bitmap.CompressFormat.JPEG,45,byteOutputStream)
        imageInByte = byteOutputStream.toByteArray()
        values.put(COLUMN_IMAGE_IN, imageInByte)

        val result = db.insert(TABLE_PEMASUKAN,null,values)
        //show message
        if(result==(0).toLong()) {
            Toast.makeText(context, "Add Pemasukan Failed", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(context, "Add Pemasukan Success", Toast.LENGTH_SHORT).show()
        }
        db.close()

    }

    fun addTambahPengeluaran(tambah:tambahModel){
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_ID_OUT, tambah.id)
        values.put(COLUMN_JUDUL_OUT, tambah.name)
        values.put(COLUMN_NOMINAL_OUT, tambah.nominal)
        values.put(COLUMN_WAKTU_OUT, tambah.tanggal)
        values.put(COLUMN_KETERANGAN_OUT, tambah.keterangan)

        //prepare image
        val byteOutputStream = ByteArrayOutputStream()
        val imageInByte: ByteArray
        tambah.image.compress(Bitmap.CompressFormat.JPEG,45,byteOutputStream)
        imageInByte = byteOutputStream.toByteArray()
        values.put(COLUMN_IMAGE_OUT, imageInByte)

        val result = db.insert(TABLE_PENGELUARAN,null,values)
        //show message
        if(result==(0).toLong()) {
            Toast.makeText(context, "Add Pengeluaran Failed", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(context, "Add Pengeluaran Success", Toast.LENGTH_SHORT).show()
        }
        db.close()

    }

    @SuppressLint("Range")
    fun showMenuPemasukan(): ArrayList<MainModel> {
        val listModel = ArrayList<MainModel>()
        val db = this.readableDatabase
        var cursor: Cursor? =null
        try {
            cursor = db.rawQuery("select * from " + TABLE_PEMASUKAN, null)
            val field: Field = CursorWindow::class.java.getDeclaredField("sCursorWindowSize")
            field.setAccessible(true)
            field.set(null, 100 * 1024 * 1024) //the 100MB is the new size
        }catch (se: SQLiteException){
            db.execSQL(CREATE_PEMASUKAN_TABLE)
            return ArrayList()
        }



        var id: Int
//        var imagebmp: Bitmap
        var imageArray: ByteArray
        var nama: String
        var nominal: Int
        var tanggal: String
        var keterangan: String


        if(cursor.moveToFirst()) {
            do {
                //get data text
                id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID_IN))
                nama = cursor.getString(cursor.getColumnIndex(COLUMN_JUDUL_IN))
                nominal = cursor.getInt(cursor.getColumnIndex(COLUMN_NOMINAL_IN))
                tanggal = cursor.getString(cursor.getColumnIndex(COLUMN_WAKTU_IN))
                keterangan = cursor.getString(cursor.getColumnIndex(COLUMN_KETERANGAN_IN))

                //get data image
                imageArray = cursor.getBlob(cursor.getColumnIndex(COLUMN_IMAGE_IN))

                //convert bytearray to bitmap
//                val byteInputStream = ByteArrayInputStream(imageArray)
//                imagebmp = BitmapFactory.decodeStream(byteInputStream)
                val model = MainModel(id = id, image = imageArray, nama = nama, nominal = nominal,  tanggal = tanggal, keterangan = keterangan)
                listModel.add(model)
            } while (cursor.moveToNext())
        }
        return listModel
    }


    @SuppressLint("Range")
    fun showMenuPengeluaran(): ArrayList<MainModel> {
        val listModel = ArrayList<MainModel>()
        val db = this.readableDatabase
        var cursor: Cursor? =null
        try {
            cursor = db.rawQuery("select * from " + TABLE_PENGELUARAN, null)
            val field: Field = CursorWindow::class.java.getDeclaredField("sCursorWindowSize")
            field.setAccessible(true)
            field.set(null, 100 * 1024 * 1024) //the 100MB is the new size
        }catch (se: SQLiteException){
            db.execSQL(CREATE_PENGELUARAN_TABLE)
            return ArrayList()
        }

        var id: Int
//        var imagebmp: Bitmap
        var imageArray: ByteArray
//        var imagebmp: Bitmap
        var nama: String
        var nominal: Int
        var tanggal: String
        var keterangan: String


        if(cursor.moveToFirst()) {
            do {
                //get data text
                id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID_OUT))
                nama = cursor.getString(cursor.getColumnIndex(COLUMN_JUDUL_OUT))
                nominal = cursor.getInt(cursor.getColumnIndex(COLUMN_NOMINAL_OUT))
                tanggal = cursor.getString(cursor.getColumnIndex(COLUMN_WAKTU_OUT))
                keterangan = cursor.getString(cursor.getColumnIndex(COLUMN_KETERANGAN_OUT))

                //get data image
                imageArray = cursor.getBlob(cursor.getColumnIndex(COLUMN_IMAGE_OUT))

                //convert bytearray to bitmap
//                val byteInputStream = ByteArrayInputStream(imageArray)
//                imagebmp = BitmapFactory.decodeStream(byteInputStream)
                val model = MainModel(id = id, image = imageArray, nama = nama, nominal = nominal,  tanggal = tanggal, keterangan = keterangan)
                listModel.add(model)
            } while (cursor.moveToNext())
        }
        return listModel
    }

    fun deleteIDin(id: String): Boolean {
        return writableDatabase.delete(TABLE_PEMASUKAN, COLUMN_ID_IN.toString() + "=?", arrayOf(id)) > 0
    }
    fun deleteIDout(id: String): Boolean {
        return writableDatabase.delete(TABLE_PENGELUARAN, COLUMN_ID_OUT.toString() + "=?", arrayOf(id)) > 0
    }

//    fun intent() {
//        Toast.makeText(this@DatabaseHelper, "Delete Success ", Toast.LENGTH_SHORT).show()
//        startActivity(Intent(this@DatabaseHelper, CatatanActivity::class.java))
//    }

//    @SuppressLint("Range")
//    fun showMenuAll(): ArrayList<MainModel> {
//        val listModel = ArrayList<MainModel>()
//        val db = this.readableDatabase
//        var cursor: Cursor? =null
//        try {
//            cursor = db.rawQuery("select * from " + TABLE_PENGELUARAN + ", " + TABLE_PEMASUKAN, null)
//            val field: Field = CursorWindow::class.java.getDeclaredField("sCursorWindowSize")
//            field.setAccessible(true)
//            field.set(null, 100 * 1024 * 1024) //the 100MB is the new size
//        }catch (se: SQLiteException){
//            db.execSQL(CREATE_PENGELUARAN_TABLE, arrayOf(CREATE_PEMASUKAN_TABLE))
//            return ArrayList()
//        }
//
//        var id: Int
//        var idout: Int
////        var imagebmp: Bitmap
//        var imageArray: ByteArray
//        var imageArrayout: ByteArray
////        var imagebmp: Bitmap
//        var nama: String
//        var namaout: String
//        var nominal: Int
//        var nominalout: Int
//        var tanggal: String
//        var tanggalout: String
//        var keterangan: String
//        var keteranganout: String
//
//
//        if(cursor.moveToFirst()) {
//            do {
//                //get data text
//                idout = cursor.getInt(cursor.getColumnIndex(COLUMN_ID_OUT))
//                namaout = cursor.getString(cursor.getColumnIndex(COLUMN_JUDUL_OUT))
//                nominalout = cursor.getInt(cursor.getColumnIndex(COLUMN_NOMINAL_OUT))
//                tanggalout = cursor.getString(cursor.getColumnIndex(COLUMN_WAKTU_OUT))
//                keteranganout = cursor.getString(cursor.getColumnIndex(COLUMN_KETERANGAN_OUT))
//
//                //get data image
//                imageArrayout = cursor.getBlob(cursor.getColumnIndex(COLUMN_IMAGE_OUT))
//
//                id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID_IN))
//                nama = cursor.getString(cursor.getColumnIndex(COLUMN_JUDUL_IN))
//                nominal = cursor.getInt(cursor.getColumnIndex(COLUMN_NOMINAL_IN))
//                tanggal = cursor.getString(cursor.getColumnIndex(COLUMN_WAKTU_IN))
//                keterangan = cursor.getString(cursor.getColumnIndex(COLUMN_KETERANGAN_IN))
//
//                //get data image
//                imageArray = cursor.getBlob(cursor.getColumnIndex(COLUMN_IMAGE_IN))
//
//                //convert bytearray to bitmap
////                val byteInputStream = ByteArrayInputStream(imageArray)
////                imagebmp = BitmapFactory.decodeStream(byteInputStream)
//                val model = MainModel(id = id + idout, image = imageArray + imageArrayout, nama = nama + namaout, nominal = nominal + nominalout,
//                    tanggal = tanggal + tanggalout, keterangan = keterangan + keteranganout)
//                listModel.add(model)
//            } while (cursor.moveToNext())
//        }
//        return listModel
//    }










}