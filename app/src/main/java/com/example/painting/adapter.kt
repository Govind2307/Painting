package com.example.painting

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class adapter(private var painting_list :List<menu>): RecyclerView.Adapter<adapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_view,parent,false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.itemView.apply {
            
             text1.text = painting_list[position].textView
        }
        }


    override fun getItemCount(): Int {
        return painting_list.size
    }
    class ItemViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val titleimage : ShapeableImageView = itemView.findViewById(R.id.image)
        val heading : TextView = itemView.findViewById(R.id.text1)
        val heading : TextView = itemView.findViewById(R.id.text2)
        val heading : TextView = itemView.findViewById(R.id.text3)

    }



}