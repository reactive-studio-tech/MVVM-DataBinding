package com.reactivestudio.viewmodelbinding.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reactivestudio.viewmodelbinding.data.model.Movie
import com.reactivestudio.viewmodelbinding.data.repository.MoviesRepository
import com.reactivestudio.viewmodelbinding.util.Result
import kotlinx.coroutines.launch

class MoviesViewModel(private val repository: MoviesRepository): ViewModel() {

    private val _movies = MutableLiveData<List<Movie>>().apply { value = emptyList() }
    val movies: LiveData<List<Movie>> = _movies

    fun loadMovies() {
        viewModelScope.launch {
            val moviesResult = repository.getMovies()

            if (moviesResult is Result.Success) {
                _movies.value = ArrayList(moviesResult.data)
            }
            else {
                _movies.value = emptyList()
            }
        }
    }
}