package com.example.irokutest.ui.list.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.irokutest.model.Movie
import com.example.irokutest.ui.base.BaseAdapter

class MovieGridAdapter : BaseAdapter<Movie, ListItemViewHolder>() {
    var clickListener: ((Movie) -> Unit)? = null

    override fun createDiffCallback(): DiffUtil.ItemCallback<Movie> =
        object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.id == newItem.id
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        return ListItemViewHolder(parent)
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        val movie = getItem(position)
        (holder as? ListItemViewHolder)?.bind(movie, clickListener)
    }

}