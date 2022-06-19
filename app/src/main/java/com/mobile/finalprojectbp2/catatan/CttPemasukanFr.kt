package com.mobile.finalprojectbp2.catatan

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobile.finalprojectbp2.R
import com.mobile.finalprojectbp2.detail.DetailActivity
import com.mobile.finalprojectbp2.tambah.TambahActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CttPemasukanFr.newInstance] factory method to
 * create an instance of this fragment.
 */
class CttPemasukanFr : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null



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
        val view =  inflater.inflate(R.layout.fragment_ctt_pemasukan, container, false)
        val rvCttIn: RecyclerView = view.findViewById(R.id.rvFrgCttIn)
        rvCttIn.layoutManager = LinearLayoutManager(activity)
        rvCttIn.adapter = CatatanAdapterIn()


        val ivAdd: ImageView = view.findViewById(R.id.ivadd)
        ivAdd.setOnClickListener{
            requireActivity().run {
                startActivity(Intent(applicationContext, TambahActivity::class.java))
                finish()
            }
        }

//        val cttIn = listOf<CatatanModel>(
//            CatatanModel(1, R.drawable.document_signed, "Gaji A", "Rp10.000.000", "Januari 1 2022"),
//            CatatanModel(1, R.drawable.document_signed, "Gaji B", "Rp5.000.000", "Januari 1 2022")
//        )
//
//        val cttinAdapter = AdapterCttin(cttIn, object : AdapterCttin.onAdapterListener {
//            override fun onClick(main: CatatanModel) {
//                Log.e("FragmentPemasukan", cttIn.toString())
//
//
//                requireActivity().run {
//                    Toast.makeText(applicationContext, main.nama.toString(), Toast.LENGTH_SHORT)
//                        .show()
//                    startActivity(
//                        Intent(applicationContext, DetailActivity::class.java)
////                            .putExtra("tvJudul", cttIn.nama)
////                            .putExtra("intent_nominal", cttIn.nominal)
////                            .putExtra("intent_tanggal", cttIn.tanggal)
////                        .putExtra("intent_image", main.)
//                    )
//                    finish()
//                }
//            }
//        })
//
//        val rvCttIn: RecyclerView = view.findViewById(R.id.rvFrgCttIn)
//        rvCttIn.layoutManager = LinearLayoutManager(activity)
//        rvCttIn.adapter = cttinAdapter

//        view.findViewById<RecyclerView>(R.id.rvFrgCttIn).apply {
//            layoutManager = LinearLayoutManager(this@MainActivity)
//            adapter = AdapterCttin
//        }
//        val ivAdd: ImageView = view.findViewById(R.id.ivadd)
//        ivAdd.setOnClickListener{
//            requireActivity().run {
//                startActivity(Intent(this, TambahActivity::class.java))
//                finish()
//            }
//        }

        return view





    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CttPemasukanFr.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic

        fun newInstance(param1: String, param2: String) =
            CttPemasukanFr().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }




    }
}