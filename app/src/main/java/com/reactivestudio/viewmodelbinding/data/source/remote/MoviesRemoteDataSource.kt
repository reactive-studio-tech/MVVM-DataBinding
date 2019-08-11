package com.reactivestudio.viewmodelbinding.data.source.remote

import com.reactivestudio.viewmodelbinding.data.model.Movie
import com.reactivestudio.viewmodelbinding.data.source.MoviesDataSource
import com.reactivestudio.viewmodelbinding.util.Result
import com.reactivestudio.viewmodelbinding.util.getFakeMovies
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MoviesRemoteDataSource internal constructor(private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO): MoviesDataSource {

    override suspend fun getMovies(): Result<List<Movie>> = withContext(ioDispatcher) {
        return@withContext try {
            Result.Success(getFakeMovies())
        } catch(e: Exception) {
            Result.Error(e)
        }
    }

    override suspend fun getMovie(id: Int): Result<Movie> = withContext(ioDispatcher) {
        return@withContext try {
            val moviesResult = getMovies()
            if (moviesResult is Result.Success) {
                val movies = moviesResult.data

                for (movie in movies) {
                    if (movie.id == id) {
                        Result.Success(movie)
                    }
                }
            }

            Result.Error(Exception("Movie not found"))
        } catch(e: Exception) {
            Result.Error(e)
        }
    }
}