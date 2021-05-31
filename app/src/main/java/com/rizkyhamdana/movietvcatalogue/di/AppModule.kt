package com.rizkyhamdana.movietvcatalogue.di

import com.rizkyhamdana.movietvcatalogue.core.domain.usecase.CatalogueInteractor
import com.rizkyhamdana.movietvcatalogue.core.domain.usecase.CatalogueUseCase
import com.rizkyhamdana.movietvcatalogue.movie.MovieViewModel
import com.rizkyhamdana.movietvcatalogue.movie.details.DetailsMovieViewModel
import com.rizkyhamdana.movietvcatalogue.tvshow.TvShowViewModel
import com.rizkyhamdana.movietvcatalogue.tvshow.details.DetailsTvShowViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<CatalogueUseCase> { CatalogueInteractor(get()) }
}

val viewModelModule = module {
    viewModel { MovieViewModel(get()) }
    viewModel { TvShowViewModel(get()) }
    viewModel { DetailsMovieViewModel(get()) }
    viewModel { DetailsTvShowViewModel(get()) }

}