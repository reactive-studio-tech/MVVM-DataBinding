package com.reactivestudio.viewmodelbinding.moviedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.reactivestudio.viewmodelbinding.R
import com.reactivestudio.viewmodelbinding.databinding.FragmentMovieDetailsBinding
import com.reactivestudio.viewmodelbinding.util.obtainViewModel

class MovieDetailsFragment: Fragment() {

    private lateinit var viewDataBinding: FragmentMovieDetailsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_movie_details, container, false)
        viewDataBinding = FragmentMovieDetailsBinding.bind(view).apply {
            viewmodel = obtainViewModel(MovieDetailsViewModel::class.java)
        }
        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner
        return viewDataBinding.root
    }
}