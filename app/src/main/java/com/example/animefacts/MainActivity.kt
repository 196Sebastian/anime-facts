package com.example.animefacts

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://anime-facts-rest-api.herokuapp.com/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

        val animeFact: AnimeFactService = retrofit.create(AnimeFactService::class.java)

        animeFact.getAnimeFactById().enqueue(object: Callback<Any>{
            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                Log.i("MainActivity", response.toString())
            }

            override fun onFailure(call: Call<Any>, t: Throwable) {
                Log.i("MainActivity", t.message ?: "Null Message")
            }

        })
    }
}