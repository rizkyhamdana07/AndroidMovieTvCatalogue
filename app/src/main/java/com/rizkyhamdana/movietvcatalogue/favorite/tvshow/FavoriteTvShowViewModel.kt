package com.rizkyhamdana.movietvcatalogue.favorite.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.rizkyhamdana.movietvcatalogue.core.data.CatalogueRepository
import com.rizkyhamdana.movietvcatalogue.core.data.source.local.entity.TvShowEntity
import com.rizkyhamdana.movietvcatalogue.core.domain.model.TvShow
import com.rizkyhamdana.movietvcatalogue.core.domain.usecase.CatalogueUseCase

class FavoriteTvShowViewModel(catalogueUseCase: CatalogueUseCase): ViewModel() {

    val getFavoriteTv = catalogueUseCase.getTvFavorite().asLiveData()

}