package com.example.painting

import android.content.ClipData
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.painting.databinding.ListViewBinding
import com.example.painting.datafiles.DataItem
import com.google.android.material.imageview.ShapeableImageView
import org.w3c.dom.Text

class Adapter: RecyclerView.Adapter<Adapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: ListViewBinding) :RecyclerView.ViewHolder(binding.root)

   /* private val diffCallback = object : DiffUtil.ItemCallback<DataItem>() {
        override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
            return oldItem == newItem
        }
    }*/


    var todos: List<DataItem> = emptyList<DataItem>()
    override fun getItemCount() = todos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(ListViewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.binding.apply {
            val item = todos[position]
            heading.text = item.user.name
            author.text = item.user.first_name
            description.text = item.user.bio

            Glide.with(image.context)
                .load(item.urls.regular)
                .centerCrop()
                .into(image)
        }
    }
}