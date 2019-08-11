package com.reactivestudio.viewmodelbinding.movies

import androidx.recyclerview.widget.RecyclerView
import com.reactivestudio.viewmodelbinding.data.model.Movie
import com.reactivestudio.viewmodelbinding.databinding.ViewholderMovieItemBinding

class MovieViewHolder(private val binding: ViewholderMovieItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie) {
        binding.movie = movie
        binding.executePendingBindings()
    }
}