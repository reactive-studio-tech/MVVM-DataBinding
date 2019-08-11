package com.reactivestudio.viewmodelbinding.data.repository

import com.reactivestudio.viewmodelbinding.data.model.Movie
import com.reactivestudio.viewmodelbinding.data.source.local.MoviesLocalDataSource
import com.reactivestudio.viewmodelbinding.data.source.remote.MoviesRemoteDataSource
import com.reactivestudio.viewmodelbinding.util.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MoviesRepositoryImpl(private val moviesLocalDataSource: MoviesLocalDataSource,
                           private val moviesRemoteDataSource: MoviesRemoteDataSource,
                           private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO): MoviesRepository {

    override suspend fun getMovies(): Result<List<Movie>> {
        return withContext(ioDispatcher) {
            moviesLocalDataSource.getMovies()
        }
    }

    override suspend fun getMovie(id: Int): Result<Movie> {
        return withContext(ioDispatcher) {
            moviesLocalDataSource.getMovie(id)
        }
    }
}