package com.example.movieapp2

import android.util.Log
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response
import retrofit2.create


class APIController: Callback<DataResponse> {

    fun start() {
        var base_url = "https://api.themoviedb.org/3/movie/"
        val apiKey = "ddeb2407d89eb56ea96d59636397646a"

        val retrofit = retrofitHandler(base_url)
        val service = retrofit.create(GetData::class.java)

        val call = service.getPopular(apiKey, "en-US", 1, "B1")
        Log.d("TEST","XXXXX00000111111")
        call.enqueue(this)
    }

    override fun onResponse(call: Call<DataResponse>, response: Response<DataResponse>) {
        Log.d("CHANGES","11111111000000000")
//        Log.d("RESPONSE",response!!.body().toString())
    }

    override fun onFailure(call: Call<DataResponse>, t: Throwable) {
        t.printStackTrace()
    }
}