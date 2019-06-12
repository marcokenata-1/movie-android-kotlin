package com.example.movieapp2

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

import kotlin.concurrent.thread


class PopularFragment : Fragment(){



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val baseUrl = "https://api.themoviedb.org/3/movie/"
        val apiKey = "ddeb2407d89eb56ea96d5963639764"

        val view =  inflater!!.inflate(R.layout.fragment_popular,container,false)

        var teks = view?.findViewById<TextView>(R.id.testerAPI)



        teks!!.setText("siap999")
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var string: String
        val service = retrofit.create(GetData::class.java)
        val call = service.getPopular(apiKey,"en-US",1,"B1")

        call.enqueue(object : retrofit2.Callback<DataResponse>{
            override fun onFailure(call: retrofit2.Call<DataResponse>, t: Throwable) {
                teks!!.setText("No data")
            }

            override fun onResponse(call: retrofit2.Call<DataResponse>, response: retrofit2.Response<DataResponse>) {
                if (response.code() == 200) {
                    val responseCall = response.body()!!

                    string = "Hasil: " + responseCall.page

                    
                }
            }
        })

        return view
    }

}

