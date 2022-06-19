//package com.mobile.finalprojectbp2.catatan
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.mobile.finalprojectbp2.R
//import com.mobile.finalprojectbp2.catatan.CatatanModel
//
//class AdapterCttin(
//
//    private val listMain: List<CatatanModel>,
//    private val listener: onAdapterListener
//
//) : RecyclerView.Adapter<AdapterCttin.ViewHolder>()
//{
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder(
//        LayoutInflater.from(parent.context).inflate(R.layout.fragment_ctt_pemasukan, parent, false)
//    )
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val main = listMain[position]
//        holder.foto.setImageResource(main.image)
//        holder.nama.text = main.nama
//        holder.nominal.text = main.nominal
//        holder.tgl.text = main.tanggal
//
//        holder.itemView.setOnClickListener{
//            listener.onClick( main )
//        }
//
//    }
//
//    override fun getItemCount() = listMain.size
//
//    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val foto = view.findViewById<ImageView>(R.id.item_foto)
//        val nama = view.findViewById<TextView>(R.id.item_nama)
//        val nominal = view.findViewById<TextView>(R.id.item_cost)
//        val tgl = view.findViewById<TextView>(R.id.item_tgl)
//    }
//
//    interface  onAdapterListener {
//        fun onClick(main: CatatanModel)
//    }
//
//
//
//}