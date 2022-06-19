package com.mobile.finalprojectbp2.catatan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mobile.finalprojectbp2.R

class CatatanAdapterOut:RecyclerView.Adapter<CatatanAdapterOut.ViewHolder>() {

    //declare dataset array
    private var foto = intArrayOf(R.drawable.document_signed, R.drawable.document_signed, R.drawable.document_signed)
    private var nama = arrayOf("Seragam Organisasi","Makan Bulanan","Bonus Gaji")
    private var timeact = arrayOf("April 15 2022","April 10 2022","April 5 2022")
    private var nominal = arrayOf("- Rp150.000", "- Rp350.000", "Rp2.000.000")

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        //instance pallete cardview
        var itemFoto: ImageView
        var itemNama: TextView
        var itemTime: TextView
        var itemNominal: TextView

        init {
            itemFoto = itemView.findViewById(R.id.item_foto)
            itemNama = itemView.findViewById(R.id.item_nama)
            itemTime = itemView.findViewById(R.id.item_tgl)
            itemNominal = itemView.findViewById(R.id.item_cost)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardview_catatan_out, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemFoto.setImageResource(foto[position])
        holder.itemNama.text = nama[position]
        holder.itemTime.text = timeact[position]
        holder.itemNominal.text = nominal[position]
    }

    override fun getItemCount(): Int {
        return nama.size
    }

}