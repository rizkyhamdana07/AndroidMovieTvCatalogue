package com.rizkyhamdana.movietvcatalogue.favorite.movie

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rizkyhamdana.movietvcatalogue.core.domain.model.Movies
import com.rizkyhamdana.movietvcatalogue.databinding.FragmentFavoriteMovieBinding
import com.rizkyhamdana.movietvcatalogue.core.ui.favorite.FavoriteMovieAdapter
import com.rizkyhamdana.movietvcatalogue.favorite.movie.details.DetailsFavoriteMovieActivity
import org.koin.androidx.viewmodel.ext.android.viewModel


class FavoriteMovieFragment : Fragment() {

    private val favoriteMovieViewModel: FavoriteMovieViewModel by viewModel()
    private lateinit var favoriteMovieAdapter: FavoriteMovieAdapter
    private var _binding: FragmentFavoriteMovieBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFavoriteMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favoriteMovieAdapter = FavoriteMovieAdapter()

        favoriteMovieViewModel.getMovieFavorite.observe(viewLifecycleOwner, {
            favoriteMovieAdapter.setMovies(it)
        })
        binding.rvFavoriteMovie.adapter = favoriteMovieAdapter
        binding.rvFavoriteMovie.layoutManager = LinearLayoutManager(requireActivity())

        favoriteMovieAdapter.setOnItemClickCallback(object : FavoriteMovieAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Movies) {
                val intent = Intent(activity, DetailsFavoriteMovieActivity::class.java)
                intent.putExtra(DetailsFavoriteMovieActivity.EXTRA_DATA, data)
                startActivity(intent)
            }

        })

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}