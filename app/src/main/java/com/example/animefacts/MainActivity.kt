package com.example.animefacts

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.airbnb.epoxy.EpoxyRecyclerView
import com.squareup.picasso.Picasso


class MainActivity : AppCompatActivity() {

    private val viewModel: SharedViewModel by lazy {
        ViewModelProvider(this)[SharedViewModel::class.java]
    }

    private val epoxyController = AnimeDetailsEpoxyController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.refreshAimeImage(5114)
        viewModel.animeImageLiveData.observe(this) { response ->
            if (response == null) {
                Toast.makeText(
                    this@MainActivity, "Unsuccessful Network Call!",
                    Toast.LENGTH_SHORT
                ).show()
                return@observe
            }
        }

        viewModel.animeGenreLiveData.observe(this) { response ->

            epoxyController.animeResponse = response
            if (response == null) {
                Toast.makeText(
                    this@MainActivity, "Unsuccessful Network Call!",
                    Toast.LENGTH_SHORT
                ).show()
                return@observe
            }

            viewModel.refreshAnimeGenre()

            val epoxyRecyclerView = findViewById<EpoxyRecyclerView>(R.id.epoxyRecyclerView)
            epoxyRecyclerView.setControllerAndBuildModels(epoxyController)
        }
    }
}