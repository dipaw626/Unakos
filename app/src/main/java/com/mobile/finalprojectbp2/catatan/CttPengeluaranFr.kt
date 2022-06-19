package com.mobile.finalprojectbp2.catatan

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobile.finalprojectbp2.R
import com.mobile.finalprojectbp2.tambah.TambahActivity
import com.mobile.finalprojectbp2.catatan.CatatanAdapterOut

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CttPengeluaranFr.newInstance] factory method to
 * create an instance of this fragment.
 */
class CttPengeluaranFr : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_ctt_pengeluaran, container, false)
        val rvCttOut: RecyclerView = view.findViewById(R.id.rvFrgCttOut)
        rvCttOut.layoutManager = LinearLayoutManager(activity)
        rvCttOut.adapter = CatatanAdapterOut()

        //all intent
        val ivAdd: ImageView = view.findViewById(R.id.ivadd)
        ivAdd.setOnClickListener{
            requireActivity().run {
                startActivity(Intent(this, TambahActivity::class.java))
                finish()
            }
        }
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CttPengeluaranFr.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CttPengeluaranFr().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}