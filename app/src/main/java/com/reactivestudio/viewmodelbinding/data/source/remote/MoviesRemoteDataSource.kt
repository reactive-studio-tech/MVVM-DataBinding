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
}