package com.lnyswz.asdemo.constraintlayout

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

import com.lnyswz.asdemo.R

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val list = ListView(this)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, LIST_ITEMS)
        list.adapter = adapter
        list.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(this@Main2Activity, LayoutDisplayActivity::class.java)
            intent.putExtra("hi", LIST_ITEMS[i])
            intent.putExtra(LayoutDisplayActivity.EXTRA_LAYOUT_ID, "")
        }
    }

    companion object {

        private val LIST_ITEMS = arrayOf("Base", "Bias", "Guide Line", "Measure", "Aspect Ratio")
    }
}
