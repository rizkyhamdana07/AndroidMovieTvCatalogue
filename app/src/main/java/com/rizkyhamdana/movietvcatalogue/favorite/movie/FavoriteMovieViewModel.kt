package com.rizkyhamdana.movietvcatalogue.favorite.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.rizkyhamdana.movietvcatalogue.core.domain.model.Movies
import com.rizkyhamdana.movietvcatalogue.core.domain.usecase.CatalogueUseCase

class FavoriteMovieViewModel(catalogueUseCase: CatalogueUseCase): ViewModel() {

    val getMovieFavorite = catalogueUseCase.getMovieFavorite().asLiveData()


}