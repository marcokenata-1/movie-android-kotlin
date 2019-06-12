package com.example.movieapp2

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PopularFragment : Fragment(){



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val baseUrl = "https://api.themoviedb.org/3/movie/"
        val apiKey = "ddeb2407d89eb56ea96d5963639764"

        val view =  inflater!!.inflate(R.layout.fragment_popular,container,false)

        var teks = view?.findViewById<TextView>(R.id.testerAPI)



//        teks!!.setText("siap999")
//        var retrofit = retrofitHandler(baseUrl)
//
//        val service = retrofit.create(GetData::class.java)
//        val call = service.getPopular(apiKey,"en-US",1,"B1")
//
//        Log.w("Call",call.toString())

        print(APIController().start())

        return view
    }

}

