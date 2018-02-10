package com.lnyswz.asdemo.constraintlayout

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.lnyswz.asdemo.R
import kotlinx.android.synthetic.main.activity_constrain.*

class ConstrainActivity : AppCompatActivity() {

    private val LIST_ITEMS = arrayOf(
        "Base",
        "Bias",
        "Guide Line",
        "Measure",
        "Aspect Ratio"
    )

    private val LAYOUT_IDS = intArrayOf(
        R.layout.layout_base,
        R.layout.layout_bias,
        R.layout.layout_guide_line,
        R.layout.layout_measure,
        R.layout.layout_aspect_ratio
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constrain)

        val list: ListView = activity_constrain
        val adapter =  ArrayAdapter(this, android.R.layout.simple_list_item_1, LIST_ITEMS)
        list.adapter = adapter
        list.setOnItemClickListener {adapterView, view, i, l ->
            run({
                val intent = Intent(this, LayoutDisplayActivity::class.java)
                intent.putExtra(Intent.EXTRA_TITLE, LIST_ITEMS[i])
                intent.putExtra(LayoutDisplayActivity.EXTRA_LAYOUT_ID, LAYOUT_IDS[i])
                startActivity(intent)
            })
        }
    }

}
