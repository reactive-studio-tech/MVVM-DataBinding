package com.reactivestudio.viewmodelbinding.movies

import com.reactivestudio.viewmodelbinding.data.model.Movie

interface MovieItemClickListener {

    fun onMovieItemPressed(movie: Movie)
}