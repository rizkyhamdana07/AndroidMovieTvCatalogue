package com.rizkyhamdana.movietvcatalogue.favorite.tvshow.details

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.rizkyhamdana.movietvcatalogue.BuildConfig
import com.rizkyhamdana.movietvcatalogue.R
import com.rizkyhamdana.movietvcatalogue.core.domain.model.TvShow
import com.rizkyhamdana.movietvcatalogue.favorite.databinding.ActivityDetailsFavoriteTvShowBinding
import com.rizkyhamdana.movietvcatalogue.favorite.di.favoriteModule
import com.rizkyhamdana.movietvcatalogue.home.HomeActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class DetailsFavoriteTvShowActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsFavoriteTvShowBinding
    private val detailsFavoriteTvShowViewModel: DetailsFavoriteTvShowViewModel by viewModel()
    companion object{
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinModules(favoriteModule)
        binding = ActivityDetailsFavoriteTvShowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<TvShow>(EXTRA_DATA) as TvShow
        setTvShowLayout(data)

        binding.fbDelete.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setNegativeButton(getString(R.string.no)) { _, _ ->}
            builder.setTitle(getString(R.string.delete_title))
            builder.setMessage(getString(R.string.delete_message))
            builder.setPositiveButton(R.string.yes){ _, _ ->
                detailsFavoriteTvShowViewModel.setFavoriteTv(data, false)
                Toast.makeText(this, getString(R.string.deleted), Toast.LENGTH_LONG).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
            builder.create().show()        }
    }

    private fun setTvShowLayout(data: TvShow){
        val backdropUrl = BuildConfig.IMAGE_URL + data.backdropPath
        val posterUrl = BuildConfig.IMAGE_URL + data.posterPath
        with(binding){
            tvTitle.text = data.title
            tvRelease.text = data.date
            tvGenre.text = data.genres
            tvOverview.text = data.overview
            tvVoteAverage.text = data.voteAverage
            Glide.with(applicationContext)
                .load(posterUrl)
                .apply(RequestOptions().placeholder(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(imgPoster)
            Glide.with(applicationContext)
                .load(backdropUrl)
                .apply(RequestOptions().placeholder(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(imgBackdrop)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unloadKoinModules(favoriteModule)
    }

}