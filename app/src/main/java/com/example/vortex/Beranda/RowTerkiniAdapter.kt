package com.example.vortex.Beranda

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.vortex.R

class RowTerkiniAdapter constructor(private val getActivity: TerkiniActivity,
                                    private val terkinirow: List<RowTerkiniItem>):
                                    RecyclerView.Adapter<RowTerkiniAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.terkini_row, parent, false)
        return MyViewHolder(view)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvterkinirow.text = terkinirow[position].tv_terkinirow
        holder.tvsubterkinirow.text = terkinirow[position].tv_subterkinirow
        holder.tvterkinidate.text = terkinirow[position].tv_terkinidate
        holder.ivterkinirow.setImageResource(terkinirow[position].drawableResId)


    }

    override fun getItemCount(): Int {
        return terkinirow.size
    }
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvterkinirow: TextView = itemView.findViewById(R.id.tv_terkinirow)
        val tvsubterkinirow: TextView = itemView.findViewById(R.id.tv_subterkinirow)
        val tvterkinidate: TextView =  itemView.findViewById(R.id.tv_terkinidate)
        val ivterkinirow: ImageView = itemView.findViewById(R.id.iv_terkinirow)
        val cardViewTerkiniRow: CardView =  itemView.findViewById(R.id.cardViewTerkiniRow)
    }

}