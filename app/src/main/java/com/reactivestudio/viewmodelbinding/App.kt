package com.reactivestudio.viewmodelbinding

import android.app.Application
import com.reactivestudio.viewmodelbinding.data.repository.MoviesRepository
import com.reactivestudio.viewmodelbinding.data.repository.MoviesRepositoryImpl
import com.reactivestudio.viewmodelbinding.data.source.local.MoviesLocalDataSource
import com.reactivestudio.viewmodelbinding.data.source.remote.MoviesRemoteDataSource

class App: Application() {

    // Fake repo just for an example.
    val repository: MoviesRepository = MoviesRepositoryImpl(MoviesLocalDataSource(), MoviesRemoteDataSource())
}