package com.example.movieapp2

import android.util.Log
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun retrofitHandler(url: String): Retrofit {

    val client = OkHttpClient()
    return Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

}

fun genreMatcher(): ArrayList<Genre> {
    val genreUrl = "https://api.themoviedb.org/3/"
    val apiKey = "ddeb2407d89eb56ea96d59636397646a"
    var retrofitGenre = retrofitHandler(genreUrl)

    var serviceGenre = retrofitGenre.create(GetData::class.java)
    val call = serviceGenre.getGenres(apiKey,"en-US")

    var genres: ArrayList<Genre> = ArrayList()

    call.enqueue(object : Callback<GenreEnc> {
        override fun onResponse(call: Call<GenreEnc>, response: Response<GenreEnc>) {
            val responseJson = response.body()!!.genres
        }

        override fun onFailure(call: Call<GenreEnc>, t: Throwable) {
            t.printStackTrace()
        }

    })

    return genres
}
