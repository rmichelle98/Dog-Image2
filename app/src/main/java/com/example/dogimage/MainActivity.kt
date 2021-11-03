package com.example.dogimage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.viewModels
import com.example.dogimage.overview.MainViewModel



class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val changeDogButton: Button = findViewById(R.id.button)

        viewModel.currentlyDisplayedImage.observe(this,
            {
            val mainImage : ImageView = findViewById(R.id.DogImageHolder)
            // Picasso.with(this).load(it.imgSrcUrl).into(mainImage)
            })

        changeDogButton.setOnClickListener {
            viewModel.getNewDog()
        }
    }
}