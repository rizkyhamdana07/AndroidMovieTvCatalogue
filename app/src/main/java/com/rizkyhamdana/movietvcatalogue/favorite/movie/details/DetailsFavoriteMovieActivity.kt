package com.rizkyhamdana.movietvcatalogue.favorite.movie.details

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.rizkyhamdana.movietvcatalogue.BuildConfig
import com.rizkyhamdana.movietvcatalogue.R
import com.rizkyhamdana.movietvcatalogue.core.domain.model.Movies
import com.rizkyhamdana.movietvcatalogue.databinding.ActivityDetailsFavoriteMovieBinding
import com.rizkyhamdana.movietvcatalogue.home.HomeActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsFavoriteMovieActivity : AppCompatActivity(){

    private lateinit var binding: ActivityDetailsFavoriteMovieBinding
    private val detailsFavoriteMovieViewModel: DetailsFavoriteMovieViewModel by viewModel()

    companion object{
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsFavoriteMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<Movies>(EXTRA_DATA) as Movies
        setMovieLayout(data)

        binding.fbDelete.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setNegativeButton(getString(R.string.no)) { _, _ ->}
            builder.setTitle(getString(R.string.delete_title))
            builder.setMessage(getString(R.string.delete_message))
            builder.setPositiveButton(R.string.yes){ _, _ ->
                detailsFavoriteMovieViewModel.setFavoriteMovie(data, false)
                Toast.makeText(this, getString(R.string.deleted), Toast.LENGTH_LONG).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
            builder.create().show()
        }
    }

    private fun setMovieLayout(data: Movies){
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
                .apply(
                    RequestOptions().placeholder(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(imgPoster)
            Glide.with(applicationContext)
                .load(backdropUrl)
                .apply(
                    RequestOptions().placeholder(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(imgBackdrop)
        }
    }

}