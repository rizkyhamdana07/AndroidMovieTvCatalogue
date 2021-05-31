package com.rizkyhamdana.movietvcatalogue.favorite.di

import com.rizkyhamdana.movietvcatalogue.favorite.movie.FavoriteMovieViewModel
import com.rizkyhamdana.movietvcatalogue.favorite.movie.details.DetailsFavoriteMovieViewModel
import com.rizkyhamdana.movietvcatalogue.favorite.tvshow.FavoriteTvShowViewModel
import com.rizkyhamdana.movietvcatalogue.favorite.tvshow.details.DetailsFavoriteTvShowViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val favoriteModule= module {
    viewModel { FavoriteMovieViewModel(get()) }
    viewModel { FavoriteTvShowViewModel(get()) }
    viewModel { DetailsFavoriteTvShowViewModel(get()) }
    viewModel { DetailsFavoriteMovieViewModel(get()) }
}