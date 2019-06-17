package com.example.movieapp2

import android.util.Log
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.ArrayBlockingQueue
import org.json.JSONArray



fun retrofitHandler(url: String): Retrofit {

    val client = OkHttpClient()
    return Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

}

var genres: ArrayList<Genre> = ArrayList()

fun genreDatabase() : Map<Int, String> {
    var map = HashMap<Int,String>()
    map.put(28, "Action")
    map.put(12, "Adventure")
    map.put(16, "Animation")
    map.put(35, "Comedy")
    map.put(80, "Crime")
    map.put(99, "Documentary")
    map.put(18, "Drama")
    map.put(10751, "Family")
    map.put(14, "Fantasy")
    map.put(36, "History")
    map.put(27,"Horror")
    map.put(10402, "Music")
    map.put(9648, "Mystery")
    map.put(10749, "Romance")
    map.put(878, "Science Fiction")
    map.put(10770,"TV Movie")
    map.put(53, "Thriller")
    map.put(10752, "War")
    map.put(37, "Western")

    return map
}

fun genreMatcher(array : ArrayList<Int>) : String{
    var builder = ""
    for (x in array){
        if (genreDatabase().containsKey(x)){
            builder += genreDatabase().get(x)+", "
        }
    }
    return builder.substring(0,builder.length-2)
}

