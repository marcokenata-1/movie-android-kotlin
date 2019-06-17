package com.example.movieapp2

import com.google.gson.annotations.SerializedName

data class DataResponse (

    var page:Int,
    var results: ArrayList<Results>,
    var total_results: Int,
    var total_pages: Int

)

data class Results (
    var poster_path: String,
    var adult: Boolean,
    var overview: String,
    var release_date: String,
    var genre_ids: ArrayList<Int>,
    var id: Int,
    var original_title:String,
    var original_language:String,
    var title:String,
    var backdrop_path:String,
    var popularity: Number,
    var vote_count: Int,
    var video: Boolean,
    var vote_average:Double
)

data class GenreEnc (
    var genres : ArrayList<Genre>
)

data class Genre (
    var id: Int,
    var name: String
)
