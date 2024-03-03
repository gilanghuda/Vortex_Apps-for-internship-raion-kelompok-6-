package com.example.vortex.Beranda

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.vortex.R

class RowBerandaAdapter constructor(private val getFragment: BerandaFragment,
                                    private val berandarow: List<RowBerandaItem>):
                                    RecyclerView.Adapter<RowBerandaAdapter.MyViewHolder>(){
     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.beranda_row, parent, false)
        return MyViewHolder(view)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvberandarow.text = berandarow[position].tv_berandarow
        holder.tvsubberandarow.text = berandarow[position].tv_berandasubrow
        holder.ivberandarow.setImageResource(berandarow[position].drawableResId)


    }

    override fun getItemCount(): Int {
        return berandarow.size
    }
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvberandarow: TextView = itemView.findViewById(R.id.tv_berandarow)
        val tvsubberandarow: TextView = itemView.findViewById(R.id.tv_subberandarow)
        val ivberandarow: ImageView = itemView.findViewById(R.id.iv_berandarow)
        val cardViewBerandaRow: CardView =  itemView.findViewById(R.id.cardViewBerandaRow)
    }

}