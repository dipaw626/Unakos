package com.mobile.finalprojectbp2.tambah

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.mobile.finalprojectbp2.R
import com.mobile.finalprojectbp2.database.DatabaseHelper


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TambahPemasukanFr.newInstance] factory method to
 * create an instance of this fragment.
 */
class TambahPemasukanFr : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var  imagebackground: ImageView

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TambahPemasukanFr.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TambahPemasukanFr().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }



        val IMAGE_REQUEST_CODE = 100
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }



    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_tambah_pemasukan, container, false)

        //instance
        imagebackground = view.findViewById(R.id.ivTbhBackground)
        val etNamein: EditText = view.findViewById(R.id.tvJudul)
        val etNominalin: EditText = view.findViewById(R.id.etJudulTbhIn)
        val etCatatanin: EditText = view.findViewById(R.id.etTbhNoteIn)
        val ivaddimage: ImageView = view.findViewById(R.id.ivAddImageTbh)
//        val btnhapusin: Button = view.findViewById(R.id.btnHapus)
        val btnSave: Button = view.findViewById(R.id.btnTbhSave)

        ivaddimage.setOnClickListener {
            pickImageGalery()
        }

        btnSave.setOnClickListener{
            val databaseHelper = DatabaseHelper(requireContext())
            val name: String = etNamein.text.toString().trim()
            val nominal: Int = etNominalin.text.toString().toInt()
            val note: String = etCatatanin.text.toString().trim()
            val bitmapDrawable: BitmapDrawable = imagebackground.drawable as BitmapDrawable
            val bitmap: Bitmap = bitmapDrawable.bitmap

            val tambahModel = tambahModel(name, nominal, note, bitmap)
            databaseHelper.addTambah(tambahModel)
        }


        return view


    }

    //inijuga bisa pickgallery
//    private fun pickFromGallery() {
//        //Create an Intent with action as ACTION_PICK
//        val intent = Intent(Intent.ACTION_PICK)
//        // Sets the type as image/*. This ensures only components of type image are selected
//        intent.type = "image/*"
//        //We pass an extra array with the accepted mime types. This will ensure only components with these MIME types as targeted.
//        val mimeTypes = arrayOf("image/jpeg", "image/png")
//        intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes)
//        // Launching the Intent
//        startActivityForResult(intent, IMAGE_REQUEST_CODE)
//    }

    private fun pickImageGalery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/"
        startActivityForResult(intent, IMAGE_REQUEST_CODE)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_REQUEST_CODE && resultCode == AppCompatActivity.RESULT_OK) {
            imagebackground.setImageURI(data?.data)
        }
    }


}