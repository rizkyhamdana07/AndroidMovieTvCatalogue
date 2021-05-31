package com.rizkyhamdana.movietvcatalogue.movie.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.rizkyhamdana.movietvcatalogue.core.domain.model.Movies
import com.rizkyhamdana.movietvcatalogue.core.domain.usecase.CatalogueUseCase

class DetailsMovieViewModel(private val catalogueUseCase: CatalogueUseCase): ViewModel() {

    fun detailsMovie(id: Int) = catalogueUseCase.getDetailsMovie(id).asLiveData()

    fun setFavoriteMovie(movies: Movies, state: Boolean) = catalogueUseCase.setMovieFavorite(movies, state)


}