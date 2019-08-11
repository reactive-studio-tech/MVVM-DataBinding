package com.reactivestudio.viewmodelbinding.util

import com.reactivestudio.viewmodelbinding.R
import com.reactivestudio.viewmodelbinding.data.model.Movie

fun getFakeMovies(): List<Movie> {
    val list = mutableListOf<Movie>()

    list.add(Movie(1, "title movie 1", "subtitle movie 1", R.string.ipsum, R.color.color_movie1, 8.4f))
    list.add(Movie(2, "title movie 2", "subtitle movie 2", R.string.ipsum, R.color.color_movie2, 5.4f))
    list.add(Movie(3, "title movie 3", "subtitle movie 3", R.string.ipsum, R.color.color_movie3, 4.8f))
    list.add(Movie(4, "title movie 4", "subtitle movie 4", R.string.ipsum, R.color.color_movie4, 7.5f))
    list.add(Movie(5, "title movie 5", "subtitle movie 5", R.string.ipsum, R.color.color_movie5, 4.0f))

    return list
}