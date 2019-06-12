package com.example.movieapp2

import com.google.gson.annotations.SerializedName

class DataResponse {

    @SerializedName("page")
    var page: Int? = null
    @SerializedName("results")
    var results : ArrayList<Results>? = null
    @SerializedName("total_results")
    var total_results: Int? = null
    @SerializedName("total_pages")
    var total_pages: Int? = null

}

class Results {
    @SerializedName("poster_path")
    var poster_path: String? = null
    @SerializedName("adult")
    var adult: Boolean? = null
    @SerializedName("overview")
    var overview: String? = null
    @SerializedName("release_date")
    var release_date: String? = null
    @SerializedName("genre_ids")
    var genre_ids: ArrayList<Int>? = null
    @SerializedName("id")
    var id : Int? = null
    @SerializedName("original_title")
    var original_title:String? = null
    @SerializedName("original_language")
    var original_language:String? = null
    @SerializedName("title")
    var title:String? = null
    @SerializedName("backdrop_path")
    var backdrop_path:String? = null
    @SerializedName("popularity")
    var popularity:Number? = null
    @SerializedName("vote_count")
    var vote_count: Int? = null
    @SerializedName("video")
    var video:Boolean? = null
    @SerializedName("vote_average")
    var vote_average: Number? = null
}