package com.mobile.finalprojectbp2.tambah

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.mobile.finalprojectbp2.R

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

    lateinit var  image: ImageView

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
//        image = view.findViewById(R.id.ivBuktiTbh)
//        val etName: EditText = view.findViewById(R.id.tvJudul)
//        val etNominal: EditText = view.findViewById(R.id.etDetailNominal)
//        val etTanggal: EditText = view.findViewById(R.id.etDetailTgl)
//        val etCatatan: EditText = view.findViewById(R.id.etDetailnote)
//        val btnhapus: Button = view.findViewById(R.id.btnHapus)


        return view


    }

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
}