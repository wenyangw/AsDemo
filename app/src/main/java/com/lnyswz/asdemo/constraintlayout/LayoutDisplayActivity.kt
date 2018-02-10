package com.lnyswz.asdemo.constraintlayout

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by Wenyang on 2018/2/10.
 */
class LayoutDisplayActivity: AppCompatActivity() {

    companion object {
        private val TAG: String = LayoutDisplayActivity :: class.java.simpleName
        val EXTRA_LAYOUT_ID: String = TAG + ".layoutId"
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        title = intent.getStringExtra(Intent.EXTRA_TITLE)
        val layoutId: Int = intent.getIntExtra(EXTRA_LAYOUT_ID, 0)
        setContentView(layoutId)
    }
}