package com.reactivestudio.viewmodelbinding.movies

import androidx.recyclerview.widget.RecyclerView
import com.reactivestudio.viewmodelbinding.data.model.Movie
import com.reactivestudio.viewmodelbinding.databinding.ViewholderMovieItemBinding

class MovieViewHolder(private val binding: ViewholderMovieItemBinding, private val listener: MovieItemClickListener?): RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie) {
        binding.movie = movie
        listener?.let {
            binding.listener = it
        }
        binding.executePendingBindings()
    }
}