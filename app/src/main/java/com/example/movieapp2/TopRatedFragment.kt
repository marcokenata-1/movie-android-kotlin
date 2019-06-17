package com.example.movieapp2

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_popular.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TopRatedFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var adapter: FragmentAdapter? = null

        val baseUrl = "https://api.themoviedb.org/3/movie/"
        val apiKey = "ddeb2407d89eb56ea96d59636397646a"

        val view =  inflater!!.inflate(R.layout.fragment_top_rated,container,false)

        var retrofit = retrofitHandler(baseUrl)

        val service = retrofit.create(GetData::class.java)
        val call = service.getTopRated(apiKey,"en-US",1,"B1")

        call.enqueue(object : Callback<DataResponse> {
            override fun onResponse(call: Call<DataResponse>, response: Response<DataResponse>) {
                Log.d("RESPONSE-TOP RATED",response!!.body().toString())
                var results = response.body()!!.results
                adapter = FragmentAdapter(getContext(),results)

                gvListMovies.adapter = adapter
            }

            override fun onFailure(call: Call<DataResponse>, t: Throwable) {
                t.printStackTrace()
            }
        })

        return view
    }


}