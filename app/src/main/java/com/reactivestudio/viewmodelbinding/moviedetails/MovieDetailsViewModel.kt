package com.reactivestudio.viewmodelbinding.moviedetails

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reactivestudio.viewmodelbinding.R
import com.reactivestudio.viewmodelbinding.data.model.Movie
import com.reactivestudio.viewmodelbinding.data.repository.MoviesRepository
import com.reactivestudio.viewmodelbinding.util.Result
import kotlinx.coroutines.launch

class MovieDetailsViewModel(private val repository: MoviesRepository): ViewModel() {

    private val _movie = MutableLiveData<Movie>()
    val movie: LiveData<Movie> = _movie

    fun loadMovie(id: Int) {
        viewModelScope.launch {
            val moviesResult = repository.getMovie(id)

            if (moviesResult is Result.Success) {
                _movie.value = moviesResult.data
            } else {
                _movie.value = null
            }
        }
    }
}