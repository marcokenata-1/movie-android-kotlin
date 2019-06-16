package com.example.movieapp2

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GetData {

    @GET("popular?")
    fun getPopular(@Query("api_key") api_key : String,
                   @Query("language") language : String,
                   @Query("page") page : Int,
                   @Query("region") region : String) : Call<DataResponse>

    @GET("top_rated?")
    fun getTopRated(@Query("api_key") api_key : String,
                   @Query("language") language : String,
                   @Query("page") page : Int,
                   @Query("region") region : String) : Call<DataResponse>

    @GET("genre/movie/list?")
    fun getGenres(@Query("api_key") api_key: String,
                  @Query("language") language: String) : Call<GenreEnc>

}