package com.rizkyhamdana.movietvcatalogue.favorite.tvshow.details

import androidx.lifecycle.ViewModel
import com.rizkyhamdana.movietvcatalogue.core.domain.model.TvShow
import com.rizkyhamdana.movietvcatalogue.core.domain.usecase.CatalogueUseCase

class DetailsFavoriteTvShowViewModel(private val catalogueUseCase: CatalogueUseCase): ViewModel() {

    fun setFavoriteTv(tvShow: TvShow, state: Boolean) = catalogueUseCase.setTvFavorite(tvShow, state)

}