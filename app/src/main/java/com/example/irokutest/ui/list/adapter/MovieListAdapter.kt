package com.example.irokutest.ui.list.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.irokutest.model.Movie
import com.example.irokutest.model.MovieListType
import com.example.irokutest.ui.base.BaseAdapter
import com.example.irokutest.ui.base.BaseViewHolder

class MovieListAdapter : BaseAdapter<MovieListAdapter.MovieHolder, BaseViewHolder>() {
    var clickListener: ((Movie) -> Unit)? = null

    override fun createDiffCallback(): DiffUtil.ItemCallback<MovieHolder> =
        object : DiffUtil.ItemCallback<MovieHolder>() {
            override fun areItemsTheSame(oldItem: MovieHolder, newItem: MovieHolder): Boolean {
                if (oldItem.viewType == VIEWTYPE.HEADER_POPULAR_MOVIES || oldItem.viewType == VIEWTYPE.HEADER_TOP_MOVIES) {
                    return oldItem.viewType == newItem.viewType
                } else {
                    return oldItem.id == newItem.id
                }
            }

            override fun areContentsTheSame(oldItem: MovieHolder, newItem: MovieHolder): Boolean {
                return if (oldItem.viewType == VIEWTYPE.HEADER_POPULAR_MOVIES || oldItem.viewType == VIEWTYPE.HEADER_TOP_MOVIES) {
                    oldItem.viewType == newItem.viewType
                } else {
                    return oldItem.id == newItem.id
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when {
            viewType == VIEWTYPE.HEADER_TOP_MOVIES.ordinal || viewType == VIEWTYPE.HEADER_POPULAR_MOVIES.ordinal -> {
                MovieHeaderViewHolder(parent)
            }
            viewType == VIEWTYPE.POPULAR_MOVIE.ordinal || viewType == VIEWTYPE.TOP_MOVIE.ordinal -> {
                MainListViewHolder(parent, MovieGridAdapter())
            }
            else -> {
                throw IllegalArgumentException("Invalid ViewHolder Type")
            }
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val movieHolder = getItem(position)
        val viewType = movieHolder.viewType

        when (viewType) {
            VIEWTYPE.HEADER_TOP_MOVIES -> {
                (holder as? MovieHeaderViewHolder)?.bind(viewType)
            }
            VIEWTYPE.HEADER_POPULAR_MOVIES -> {
                (holder as? MovieHeaderViewHolder)?.bind(viewType)
            }
            VIEWTYPE.POPULAR_MOVIE -> {
                (holder as? MainListViewHolder)?.bind(movieHolder.movies ?: return, clickListener)
            }
            VIEWTYPE.TOP_MOVIE -> {
                (holder as? MainListViewHolder)?.bind(movieHolder.movies ?: return, clickListener)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).viewType.id
    }

    fun submitMovieList(movies: List<Movie>) {
        val movieHolders = arrayListOf<MovieHolder>()

        val popularMovies = arrayListOf<Movie>()
        val topMovies = arrayListOf<Movie>()

        movies.forEach {
            if (it.listTypes.contains(MovieListType.TOP_RATED.id)) {
                topMovies.add(it)
            }

            if (it.listTypes.contains(MovieListType.POPULAR.id)) {
                popularMovies.add(it)
            }
        }

        movieHolders.apply {
            this.add(MovieHolder(VIEWTYPE.HEADER_POPULAR_MOVIES))
            this.add(
                MovieHolder(
                    VIEWTYPE.POPULAR_MOVIE,
                    popularMovies.firstOrNull()?.id ?: 0,
                    popularMovies
                )
            )
            this.add(MovieHolder(VIEWTYPE.HEADER_TOP_MOVIES))
            this.add(
                MovieHolder(
                    VIEWTYPE.TOP_MOVIE,
                    topMovies.firstOrNull()?.id ?: 0,
                    topMovies
                )
            )
        }

        this.submitList(movieHolders)
    }

    data class MovieHolder(
        val viewType: VIEWTYPE,
        val id: Int = 0,
        val movies: List<Movie>? = null
    )

    enum class VIEWTYPE {
        HEADER_POPULAR_MOVIES,
        HEADER_TOP_MOVIES,
        POPULAR_MOVIE,
        TOP_MOVIE;

        var id: Int = 0
            get() = this.ordinal

    }
}