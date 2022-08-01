package com.example.animefacts

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.animefacts.network.GetAnimeByGenreResponse
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

        val textView = findViewById<TextView>(R.id.textView)
        val textView1 = findViewById<TextView>(R.id.textView1)
        val textView2 = findViewById<TextView>(R.id.textView2)
        val textView3 = findViewById<TextView>(R.id.textView3)
        val textView4 = findViewById<TextView>(R.id.textView4)

        val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.jikan.moe/v4/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

        val animeFact: AnimeFactService = retrofit.create(AnimeFactService::class.java)

        animeFact.getAnimeFactById().enqueue(object: Callback<GetAnimeByGenreResponse>{
            override fun onResponse(call: Call<GetAnimeByGenreResponse>, response: Response<GetAnimeByGenreResponse>) {
                Log.i("MainActivity", response.toString())

                if (!response.isSuccessful) {
                    Toast.makeText(this@MainActivity, "Unsuccessful network call", Toast.LENGTH_SHORT).show()
                }

                val body = response.body()!!
                val name = body.data[1].name
                val name1 = body.data[1].url
                val name2 = body.data[1].count.toString()

                textView.text = name
                textView1.text = name1
                textView2.text = name2

            }

            override fun onFailure(call: Call<GetAnimeByGenreResponse>, t: Throwable) {
                Log.i("MainActivity", t.message ?: "Null Message")
            }
        })
    }
}