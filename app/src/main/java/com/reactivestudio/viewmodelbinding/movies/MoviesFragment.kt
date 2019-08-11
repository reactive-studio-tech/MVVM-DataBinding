package com.reactivestudio.viewmodelbinding.movies

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.reactivestudio.viewmodelbinding.R
import com.reactivestudio.viewmodelbinding.data.model.Movie
import com.reactivestudio.viewmodelbinding.databinding.FragmentMoviesBinding
import com.reactivestudio.viewmodelbinding.util.GridItemDecorator
import com.reactivestudio.viewmodelbinding.util.obtainViewModel

/**
 * Movie List fragment.
 */
class MoviesFragment: Fragment(), MovieItemClickListener {

    private lateinit var viewDataBinding: FragmentMoviesBinding

    private val adapter = MoviesAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_movies, container, false)
        viewDataBinding = FragmentMoviesBinding.bind(view).apply {
            viewmodel = obtainViewModel(MoviesViewModel::class.java)
        }

        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.moviesRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        viewDataBinding.moviesRecyclerView.addItemDecoration(GridItemDecorator(requireContext(), 2, 2))
        viewDataBinding.moviesRecyclerView.adapter = adapter
        adapter.setMovieClickListener(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner
        viewDataBinding.viewmodel?.loadMovies()
    }

    override fun onMovieItemPressed(movie: Movie) {
        val action = MoviesFragmentDirections.actionMoviesFragmentToMovieDetailsFragment(movie.id)
        findNavController().navigate(action)
    }
}