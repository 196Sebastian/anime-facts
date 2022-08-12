package com.example.animefacts

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso


class MainActivity : AppCompatActivity() {

    private val viewModel: SharedViewModel by lazy {
        ViewModelProvider(this)[SharedViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val title = findViewById<TextView>(R.id.animeGenreTextView)
        val link = findViewById<TextView>(R.id.actualLinkTextView)
        val number = findViewById<TextView>(R.id.numberOfAnimeInGenreTextView)
        val imageView = findViewById<ImageView>(R.id.animeGenreImageView)


        viewModel.refreshAimeImage(1225)
        viewModel.refreshAnimeGenre()
        viewModel.animeImageLiveData.observe(this) { response ->
            if (response == null) {
                Toast.makeText(
                    this@MainActivity, "Unsuccessful Network Call!",
                    Toast.LENGTH_SHORT
                ).show()
                return@observe
            }

            val image = response.data[1].jpg.large_image_url
            Picasso.get().load(image).into(imageView)
        }

        viewModel.animeGenreLiveData.observe(this) { response ->
            if (response == null) {
                Toast.makeText(
                    this@MainActivity, "Unsuccessful Network Call!",
                    Toast.LENGTH_SHORT
                ).show()
                return@observe
            }

            title.text = response.data[1].name
            link.text = response.data[1].url
            number.text = response.data[1].count.toString()
        }
    }
}