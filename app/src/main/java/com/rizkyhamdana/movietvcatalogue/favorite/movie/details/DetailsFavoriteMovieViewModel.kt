package com.rizkyhamdana.movietvcatalogue.favorite.movie.details

import androidx.lifecycle.ViewModel
import com.rizkyhamdana.movietvcatalogue.core.domain.model.Movies
import com.rizkyhamdana.movietvcatalogue.core.domain.usecase.CatalogueUseCase

class DetailsFavoriteMovieViewModel(private val catalogueUseCase: CatalogueUseCase): ViewModel() {

    fun setFavoriteMovie(movies: Movies, state: Boolean) = catalogueUseCase.setMovieFavorite(movies, state)

}