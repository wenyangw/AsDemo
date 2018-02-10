package com.lnyswz.asdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class CustomViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var layout: LinearLayout = LinearLayout(this)
        super.setContentView(layout)
        var ball: DrawView = DrawView(this)
        ball.minimumWidth = 300
        ball.minimumHeight = 500
        layout.addView(ball)
    }
}
