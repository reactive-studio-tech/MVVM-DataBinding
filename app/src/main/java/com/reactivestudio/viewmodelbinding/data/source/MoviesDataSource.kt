package com.reactivestudio.viewmodelbinding.data.source

import com.reactivestudio.viewmodelbinding.data.model.Movie
import com.reactivestudio.viewmodelbinding.util.Result

interface MoviesDataSource {

    suspend fun getMovies(): Result<List<Movie>>

    suspend fun getMovie(id: Int): Result<Movie>
}