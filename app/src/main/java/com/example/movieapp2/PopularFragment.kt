package com.example.movieapp2

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.core.content.getSystemService
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_popular.*
import kotlinx.android.synthetic.main.movie_ticket.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.StringBuilder

class PopularFragment : Fragment(){


//    var listOfMovies = ArrayList<Results>()
    var adapter: FragmentAdapter? = null
    val apiKey = "ddeb2407d89eb56ea96d59636397646a"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

    val baseUrl = "https://api.themoviedb.org/3/movie/"

    val view =  inflater!!.inflate(R.layout.fragment_popular,container,false)


//    var teks = view?.findViewById<TextView>(R.id.testerAPI)



//        teks!!.setText("siap999")
    var retrofit = retrofitHandler(baseUrl)
//
    val service = retrofit.create(GetData::class.java)
    val call = service.getPopular(apiKey,"en-US",1,"B1")

    val genres = genreMatcher()

    call.enqueue(object : Callback<DataResponse>{
        override fun onResponse(call: Call<DataResponse>, response: Response<DataResponse>) {
            Log.d("RESPONSE-POPULAR",response!!.body().toString())

            var results = response.body()!!.results
            adapter = FragmentAdapter(getContext(),results,genres)

            gvListMovies.adapter = adapter
        }

        override fun onFailure(call: Call<DataResponse>, t: Throwable) {
            t.printStackTrace()
        }
    })


    return view
    }



    class FragmentAdapter :  BaseAdapter {

        var context:Context? = null
        var listOfMovies = ArrayList<Results>()
        var listOfGenres = ArrayList<Genre>()

        constructor(context: Context?, listOfMovies: ArrayList<Results>, listOfGenres : ArrayList<Genre>){
            this.context = context
            this.listOfMovies = listOfMovies
            this.listOfGenres = listOfGenres
        }



        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var movie = listOfMovies[p0]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var movieView = inflator.inflate(R.layout.movie_ticket,null)

            var url = "https://image.tmdb.org/t/p/w500" + movie.poster_path

            Picasso.get()
                .load(url)
                .into(movieView.ivMovieImage)



            movieView.tvMovieName.text = movie.original_title


            Log.d("GENRE", listOfGenres.toString())

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

}

