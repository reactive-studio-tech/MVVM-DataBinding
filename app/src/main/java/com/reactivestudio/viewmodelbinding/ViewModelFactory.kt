/*
 * Copyright (C) 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.reactivestudio.viewmodelbinding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.reactivestudio.viewmodelbinding.data.repository.MoviesRepository
import com.reactivestudio.viewmodelbinding.moviedetails.MovieDetailsViewModel
import com.reactivestudio.viewmodelbinding.movies.MoviesViewModel

class ViewModelFactory(private val repository: MoviesRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>) =
        with(modelClass) {
            when {
                isAssignableFrom(MoviesViewModel::class.java) ->
                    MoviesViewModel(repository)
                isAssignableFrom(MovieDetailsViewModel::class.java) ->
                    MovieDetailsViewModel(repository)
                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T
}
