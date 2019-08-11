package com.reactivestudio.viewmodelbinding.data.repository

import com.reactivestudio.viewmodelbinding.data.model.Movie
import com.reactivestudio.viewmodelbinding.util.Result

interface MoviesRepository {

    suspend fun getMovies(): Result<List<Movie>>
}