package com.example.vortex.Beranda

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.vortex.R

class RowPembukuanAdapter constructor(private val getActivity: PembukuanActivity,
                                      private val pembukuanrow: List<RowPembukuanItem>):
    RecyclerView.Adapter<RowPembukuanAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_list_pendapatan, parent, false)
        return MyViewHolder(view)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvkategorirow.text = pembukuanrow[position].tv_rowkategori
        holder.tvpembayaranrow.text = pembukuanrow[position].tv_rowpembayaran
        holder.tvjumlahuangrow.text = pembukuanrow[position].tv_rowjumlahuang

    }

    override fun getItemCount(): Int {
        return pembukuanrow.size
    }
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvkategorirow: TextView = itemView.findViewById(R.id.tv_rowkategori)
        val tvpembayaranrow: TextView = itemView.findViewById(R.id.tv_rowpembayaran)
        val tvjumlahuangrow: TextView =  itemView.findViewById(R.id.tv_rowjumlahuang)

    }

}