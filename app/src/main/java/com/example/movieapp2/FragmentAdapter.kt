package com.example.movieapp2

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_ticket.view.*

class FragmentAdapter : BaseAdapter {

    var context: Context? = null
    var listOfMovies = ArrayList<Results>()

    constructor(context: Context?, listOfMovies: ArrayList<Results>){
        this.context = context
        this.listOfMovies = listOfMovies

    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var movie = listOfMovies[p0]
        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var movieView = inflator.inflate(R.layout.movie_ticket,null)

        var url = "https://image.tmdb.org/t/p/w500" + movie.poster_path

        Picasso.get()
            .load(url)
            .into(movieView.ivMovieImage)

        var genres = genreMatcher(movie.genre_ids)

        movieView.tvMovieName.text = movie.original_title
        movieView.tvGenreName.text = genres

        movieView.setOnClickListener {
            val intent = Intent(context,MovieDetails::class.java)
            intent.putExtra("poster_path",movie.poster_path)
            intent.putExtra("backdrop_path",movie.backdrop_path)
            intent.putExtra("original_title",movie.original_title)
            intent.putExtra("vote_average",movie.vote_average)
            intent.putExtra("vote_count",movie.vote_count)
            intent.putExtra("release_date",movie.release_date)
            intent.putExtra("overview",movie.overview)
            intent.putExtra("original_language",movie.original_language)
            context!!.startActivity(intent)
        }

        return movieView

    }

    override fun getItem(p0: Int): Any {
        return listOfMovies[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return listOfMovies.size
    }

}