package com.reactivestudio.viewmodelbinding.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.reactivestudio.viewmodelbinding.data.model.Movie
import com.reactivestudio.viewmodelbinding.databinding.ViewholderMovieItemBinding
import com.reactivestudio.viewmodelbinding.util.BindableAdapter

class MoviesAdapter: RecyclerView.Adapter<MovieViewHolder>(), BindableAdapter<List<Movie>> {

    /**
     * Data source list.
     */
    private val dataSource = mutableListOf<Movie>()

    private var listener: MovieItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ViewholderMovieItemBinding.inflate(inflater, parent, false)
        return MovieViewHolder(binding, listener)
    }

    override fun getItemCount() = dataSource.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(dataSource[position])
    }

    override fun setData(data: List<Movie>) {
        dataSource.clear()
        dataSource.addAll(data)
        notifyDataSetChanged()
    }

    fun setMovieClickListener(movieListener: MovieItemClickListener) {
        listener = movieListener
    }

}