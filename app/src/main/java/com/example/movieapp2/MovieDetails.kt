package com.example.movieapp2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_details.*

class MovieDetails : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_details)

        val bundle = intent.extras!!
        var url = "https://image.tmdb.org/t/p/w500"
        var urlBackdrop = "https://image.tmdb.org/t/p/original"

        Picasso.get()
            .load(urlBackdrop + bundle.getString("backdrop_path"))
            .into(ivBackdrop)

        Picasso.get()
            .load(url + bundle.getString("poster_path"))
            .into(ivMoviePoster)

        var voteDisplay = bundle.getInt("vote_count").toString() +" votes"

        tvMovieTitle.text = bundle.getString("original_title")
        tvVoteAverage.text = bundle.getDouble("vote_average").toString()
        tvVoteCount.text = voteDisplay
        tvReleaseDate.text = bundle.getString("release_date")
        tvOriginalLanguage.text = bundle.getString("original_language")
        tvDescription.text = bundle.getString("overview")

    }
}