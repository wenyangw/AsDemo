package com.lnyswz.asdemo

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

/**
 * Created by Wenyang on 2018/2/10.
 */
class DrawView: View {
    private var currentX: Float = 50f
    private var currentY: Float = 50f
    private var p: Paint = Paint()

    constructor(context: Context) : super(context)

    constructor(context: Context, set: AttributeSet) : super(context, set)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        p.color = Color.RED
        if (canvas != null) canvas.drawCircle(currentX, currentY, 25f, p)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        //return super.onTouchEvent(event)
        if (event != null) {
            currentX = event.x
        }
        if (event != null) {
            currentY = event.y
        }
        invalidate()
        return true
    }


}