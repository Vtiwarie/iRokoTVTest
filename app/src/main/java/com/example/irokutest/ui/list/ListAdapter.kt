package com.example.irokutest.ui.list

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.irokutest.model.Movie
import com.example.irokutest.ui.base.BaseAdapter

class ListAdapter : BaseAdapter<Movie, ListViewHolder>() {
    override fun createDiffCallback(): DiffUtil.ItemCallback<Movie> =
        object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.id == newItem.id
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(parent)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}