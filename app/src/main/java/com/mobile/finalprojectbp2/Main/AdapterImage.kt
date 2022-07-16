package com.mobile.finalprojectbp2.Main

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.drawable.toBitmap
import androidx.recyclerview.widget.RecyclerView
import com.mobile.finalprojectbp2.R
import com.mobile.finalprojectbp2.detail.DetailActivity
import java.io.ByteArrayInputStream

class AdapterImage(

    private val listMain: ArrayList<MainModel>,
    private val listener: onAdapterListener

    ) : RecyclerView.Adapter<AdapterImage.HistoryViewHolder>()
    {
        inner class HistoryViewHolder(v: View):RecyclerView.ViewHolder(v) {
//            val textId: TextView
            val tvjudul: TextView
            val tvNominal: TextView
            val tvTanggal: TextView
//            val tvCatatan: TextView
            val imagedetail: ImageView
//            val btnhapus: Button
//            val btnupdate: Button


            init {
//                textId = v.findViewById(R.id.textIdMakanan)
                tvjudul = v.findViewById(R.id.item_nama)
                tvNominal = v.findViewById(R.id.item_cost)
                tvTanggal = v.findViewById(R.id.item_tgl)
//                tvCatatan = v.findViewById(R.id.tvDetailnote)
                imagedetail = v.findViewById(R.id.item_foto)
//                btnhapus = v.findViewById(R.id.btnHapus)
//                btnupdate = v.findViewById(R.id.btnBack)

//                imagedetail.setOnClickListener{
//                    DetailActivity.imagedetail = imagedetail.drawable.toBitmap(30,30,null)
//                }


            }
            fun bind(data: MainModel) {
//                val id:Int = data.id
                val nama:String = data.nama
                val cost:Int = data.nominal
                val tgl:String = data.tanggal
                val gambar: ByteArray = data.image

//                textId.text = id.toString()
                tvjudul.text = nama
                tvNominal.text = cost.toString()
                tvTanggal.text = tgl

                val byteInputStream = ByteArrayInputStream(gambar)
                val imagebmp: Bitmap = BitmapFactory.decodeStream(byteInputStream)
                imagedetail.setImageBitmap(imagebmp)

            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterImage.HistoryViewHolder{
            val layoutInflater = LayoutInflater.from(parent?.context)
            val cellForRow = layoutInflater.inflate(R.layout.cardview_main, parent, false)
            return HistoryViewHolder((cellForRow))
        }



        override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
            val main = listMain[position]

            holder.bind(listMain[position])
//            holder.foto.setImageBitmap(main.image)
//            holder.nama.text = main.nama
//            holder.nominal.text = main.nominal.toString()
//            holder.tgl.text = main.tanggal
//            holder.catatan.text = main.keterangan

            holder.itemView.setOnClickListener{
                listener.onClick( main )
            }
//            holder.btnhapus.setOnClickListener{
//                listener.onClick( main )
//            }
//            holder.btnupdate.setOnClickListener{
//                listener.onUpdate( main )
//            }

        }

        override fun getItemCount(): Int {
            return listMain.size
        }

//        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//            val foto = view.findViewById<ImageView>(R.id.item_foto)
//            val nama = view.findViewById<TextView>(R.id.item_nama)
//            val nominal = view.findViewById<TextView>(R.id.item_cost)
//            val tgl = view.findViewById<TextView>(R.id.item_tgl)
////            val catatan = view.findViewById<TextView>(R.id.tvDetailnote)
//        }

        interface  onAdapterListener {
            fun onClick(main: MainModel)
//            fun onDelete(main: MainModel)
//            fun onUpdate(main: MainModel)
        }


    }