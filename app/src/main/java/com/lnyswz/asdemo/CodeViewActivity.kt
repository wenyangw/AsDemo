package com.lnyswz.asdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import java.util.*

class CodeViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var layout: LinearLayout = LinearLayout(this)
        super.setContentView(layout)
        layout.orientation = LinearLayout.VERTICAL

        val show: TextView = TextView(this)
        layout.addView(show)

        var btn: Button = Button(this)
        btn.setText(R.string.btn_ok)
        btn.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        layout.addView(btn)
        btn.setOnClickListener {
            show.text = "Hello android, " + Date()
        }
    }
}
