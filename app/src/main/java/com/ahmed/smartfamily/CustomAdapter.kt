package com.ahmed.smartfamily


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private var Array:ArrayList<Int>) :RecyclerView.Adapter<CustomAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.imageView.setImageResource(Array[position])
    }

    override fun getItemCount(): Int {
        return Array.size
    }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val imageView=itemView.findViewById<ImageView>(R.id.ranking_iv1)
    }
}