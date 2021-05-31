package com.rizkyhamdana.movietvcatalogue.tvshow.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.rizkyhamdana.movietvcatalogue.core.domain.model.TvShow
import com.rizkyhamdana.movietvcatalogue.core.domain.usecase.CatalogueUseCase

class DetailsTvShowViewModel(private val catalogueUseCase: CatalogueUseCase): ViewModel() {

    fun detailsTvShow(id: Int) = catalogueUseCase.getDetailsTv(id).asLiveData()

    fun setFavoriteTv(tvShow: TvShow, state: Boolean) = catalogueUseCase.setTvFavorite(tvShow, state)


}