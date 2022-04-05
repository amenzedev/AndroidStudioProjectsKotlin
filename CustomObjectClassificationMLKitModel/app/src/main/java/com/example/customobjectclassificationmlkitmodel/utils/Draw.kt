package com.example.customobjectclassificationmlkitmodel.utils

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.DisplayMetrics
import android.view.View

class Draw(context: Context?, var rect: Rect, var text:String,var dimension_width:Int, var dimension_height:Int, var in_count:Int, var out_count:Int) : View(context) {

    lateinit var boundaryPaint: Paint
    lateinit  var textPaint: Paint
    val space_among_score_texts = dimension_width/3
    var Passengers_In = Rect(50, 50, space_among_score_texts, 100)
    var Passengers_net=Rect(50+space_among_score_texts, 50, 2*space_among_score_texts, 100)
    var Passengers_out=Rect(2*space_among_score_texts+50, 50, 3*space_among_score_texts, 100)
    var net = in_count - out_count
    init {
        init()
    }
    private fun init(){
        boundaryPaint= Paint()
        boundaryPaint.color= Color.BLACK
        boundaryPaint.strokeWidth = 10f
        boundaryPaint.style = Paint.Style.STROKE

        textPaint= Paint()
        textPaint.color= Color.BLACK
        textPaint.textSize = 50f
        textPaint.style = Paint.Style.FILL



    }
    override fun onDraw(canvas: Canvas?)
    {
        super.onDraw(canvas)

        canvas?.drawText(text, rect.centerX().toFloat(), rect.centerY().toFloat(),textPaint)
        canvas?.drawRect(rect.left.toFloat(),rect.top.toFloat(),rect.right.toFloat(),rect.bottom.toFloat(),boundaryPaint)

        canvas?.drawText("In : $in_count",Passengers_In.left.toFloat(), Passengers_In.top.toFloat(),textPaint)
        canvas?.drawText("Out : $out_count",Passengers_out.left.toFloat(), Passengers_out.top.toFloat(),textPaint)
        canvas?.drawText("Net : $net",Passengers_net.left.toFloat(), Passengers_net.top.toFloat(),textPaint)

    }
}