package com.lnyswz.asdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.widget.ImageView

class MixViewActivity : AppCompatActivity() {

    val images: IntArray = intArrayOf(R.drawable.ajax, R.drawable.html, R.drawable.java, R.drawable.javaee, R.drawable.swift)
    var currentImage: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mix_view)
        var layout: ConstraintLayout = findViewById(R.id.root)

        var image: ImageView = ImageView(this)
        layout.addView(image)
        image.setImageResource(images[0])
        image.setOnClickListener {
            image.setImageResource(images[++currentImage % images.size])
        }
    }
}
