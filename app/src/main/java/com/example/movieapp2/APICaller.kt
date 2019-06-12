package com.example.movieapp2

import okhttp3.*



class APICaller {
    var client = OkHttpClient()


    fun getPopular(page: Int):Response {

        var Request = Request.Builder()
            .url("https://api.themoviedb.org/3/movie/popular?api_key=ddeb2407d89eb56ea96d59636397646a&language=en-US&page=${page}")
            .get()
            .build()


        var call = client.newCall(Request).execute()

        return call


    }

    fun getTopRated(page:Integer,callback: Callback):Call {
        var Request = Request.Builder()
            .url("https://api.themoviedb.org/3/movie/top_rated?api_key=ddeb2407d89eb56ea96d59636397646a&language=en-US&page=${page}")
            .build()

        val call = client.newCall(Request)
        call.enqueue(callback)
        return call
    }

    companion object {
        val JSON = MediaType.parse("application/json; charset=utf-8")
    }


}