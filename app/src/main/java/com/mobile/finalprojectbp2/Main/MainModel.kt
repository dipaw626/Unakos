package com.mobile.finalprojectbp2.Main

import android.graphics.Bitmap
import com.mobile.finalprojectbp2.R

data class MainModel(
    val id: Int,
    val image: ByteArray,
    val nama: String,
    val nominal: Int,
    val tanggal: String,
    val keterangan: String

)
