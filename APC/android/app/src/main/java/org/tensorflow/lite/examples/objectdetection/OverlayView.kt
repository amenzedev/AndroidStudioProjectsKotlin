/*
 * Copyright 2022 The TensorFlow Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.tensorflow.lite.examples.objectdetection

import android.content.Context
import android.content.res.Configuration
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF
import android.os.SystemClock
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import java.util.LinkedList
import kotlin.math.max
import org.tensorflow.lite.task.vision.detector.Detection
import java.util.ArrayList
import java.util.HashMap
import kotlin.math.abs

class OverlayView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private var results: List<Detection> = LinkedList<Detection>()
    private var boxPaint = Paint()
    private var textBackgroundPaint = Paint()
    private var textPaint = Paint()

    private var scaleFactor: Float = 1f

    private var bounds = Rect()

    private var tracked_objects = HashMap<String, Int>()

    var leftBoundary = (0.4* ImageWidth).toInt()
    var rightBoundary = (0.9* ImageWidth).toInt()
    var middleBoundary = (0.65* ImageWidth).toInt()
    var delay = 700




    var space_among_score_texts = 1080/3
    var Passengers_In = Rect(50, 50, space_among_score_texts, 100)
    var door_status = Rect(50, 100, space_among_score_texts, 100)
    var Passengers_net=Rect(50+space_among_score_texts, 50, 2*space_among_score_texts, 100)
    var Passengers_out=Rect(2*space_among_score_texts+50, 50, 3*space_among_score_texts, 100)
    var net = MainActivity.passengers_in_count - MainActivity.passengers_out_count

    init {
        initPaints()
        space_among_score_texts = ImageWidth/3
        MainActivity.tracking = CentroidTracking(5)
        middleBoundary = (0.5* ImageWidth).toInt()
    }

    fun clear() {
        textPaint.reset()
        textBackgroundPaint.reset()
        boxPaint.reset()
        invalidate()
        initPaints()
    }

    private fun initPaints() {
        textBackgroundPaint.color = Color.BLACK
        textBackgroundPaint.style = Paint.Style.FILL
        textBackgroundPaint.textSize = 50f

        textPaint.color = Color.WHITE
        textPaint.style = Paint.Style.FILL
        textPaint.textSize = 50f

        boxPaint.color = ContextCompat.getColor(context!!, R.color.bounding_box_color)
        boxPaint.strokeWidth = 8F
        boxPaint.style = Paint.Style.STROKE
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        //middleBoundary = (0.4* ImageWidth).toInt()

        canvas.drawText("In : ${MainActivity.passengers_in_count}",Passengers_In.left.toFloat(), Passengers_In.top.toFloat(),textPaint)
        canvas.drawText("Out : ${MainActivity.passengers_out_count}",Passengers_out.left.toFloat(), Passengers_out.top.toFloat(),textPaint)
        net = MainActivity.passengers_in_count - MainActivity.passengers_out_count
        canvas.drawText("Net : ${net}",Passengers_net.left.toFloat(), Passengers_net.top.toFloat(),textPaint)
        canvas.drawRect(0F,150F, middleBoundary.toFloat(), ImageHeight-50F,boxPaint)



        for (result in results) {
            val boundingBox = result.boundingBox

            val top = boundingBox.top * scaleFactor
            val bottom = boundingBox.bottom * scaleFactor
            val left = boundingBox.left * scaleFactor
            val right = boundingBox.right * scaleFactor
            if(result.categories[0].label == "door") {
                //implement the door status here like telling the door is closed
                val drawableText = "door_closed"
                // Draw text for door closed
                canvas.drawText(drawableText, 0F, 120F, textPaint)
                break
            }


            val cX = ((left + right) / 2).toInt()
            val cY = ((top + bottom) / 2).toInt()
            val key = cX.toString()+"+"+cY.toString()



            // Draw bounding box around detected objects
            val drawableRect = RectF(left, top, right, bottom)
            val vertex_offset = ((right-left)/2).toInt() // centroid to center

            if(tracked_objects[key] != null)
            {
                var inferenceTime_counting = SystemClock.uptimeMillis()
                update_passenger_count(tracked_objects[key].toString(),(left+vertex_offset).toInt(),(right-vertex_offset).toInt())
                inferenceTime_counting = SystemClock.uptimeMillis() - inferenceTime_counting
                Log.d("counting_delay",inferenceTime_counting.toString())
                canvas.drawRect(drawableRect, boxPaint)
                val drawableText =
                    result.categories[0].label + " " +tracked_objects[key].toString()
                // Draw rect behind display text
                textBackgroundPaint.getTextBounds(drawableText, 0, drawableText.length, bounds)
                val textWidth = bounds.width()
                val textHeight = bounds.height()
                canvas.drawRect(
                    left,
                    top,
                    left + textWidth + Companion.BOUNDING_RECT_TEXT_PADDING,
                    top + textHeight + Companion.BOUNDING_RECT_TEXT_PADDING,
                    textBackgroundPaint
                )

                // Draw text for detected object
                canvas.drawText(drawableText, left, top + bounds.height(), textPaint)
            }


        }
    }

    fun setResults(
      detectionResults: MutableList<Detection>,
      imageHeight: Int,
      imageWidth: Int,
    ) {
        results = detectionResults

        // PreviewView is in FILL_START mode. So we need to scale up the bounding box to match with
        // the size that the captured images will be displayed.
        scaleFactor = max(width * 1f / imageWidth, height * 1f / imageHeight)
        ImageHeight= (imageHeight*scaleFactor).toInt()
        ImageWidth= (imageWidth*scaleFactor).toInt()

        Log.d("dimensions", ImageHeight.toString()+" "+ ImageWidth.toString())

        var inferenceTime_tracking = SystemClock.uptimeMillis()
        //tracking id creation
        val rectangles = ArrayList<RectF>()
        for (result in results) {
            val boundingBox = result.boundingBox
            //System.out.println(result.categories[0].label + " " +String.format("%.2f", result.categories[0].score))
            if(result.categories[0].label == "door") {
                //implement the door status here
                middleBoundary = (boundingBox.right * scaleFactor).toInt()
                if(abs(middleBoundary - (0.4* ImageWidth).toInt()) > 20)
                    middleBoundary=(0.4* ImageWidth).toInt()

            }


            val top = boundingBox.top * scaleFactor
            val bottom = boundingBox.bottom * scaleFactor
            val left = boundingBox.left * scaleFactor
            val right = boundingBox.right * scaleFactor
            if(((right-left)*(bottom-top) > (0.1* ImageWidth* ImageHeight)))
            {
                // Draw bounding box around detected objects
                val drawableRect = RectF(left, top, right, bottom)
                rectangles.add(drawableRect)
            }

        }
        val tracking_results = MainActivity.tracking.update(rectangles)
        for ((id, centroid) in tracking_results.entries) {
            var key = centroid.first.toString()+"+"+centroid.second.toString()
            tracked_objects[key]=id
            Log.v("test1", tracking_results.toString())
        }
        inferenceTime_tracking = SystemClock.uptimeMillis() - inferenceTime_tracking
        Log.d("tracking_delay",inferenceTime_tracking.toString())


    }

    companion object {
        private const val BOUNDING_RECT_TEXT_PADDING = 8

        var ImageWidth = 320
        var ImageHeight = 320
        var door_status = false

    }


    fun update_passenger_count(tracking_id:String, object_left_corner:Int, object_right_corner:Int)
    {
        val number = IntArray(2)
        number[0]=0
        number[1]=0
        //leftBoundary = (0.4* ImageWidth).toInt()
        //rightBoundary = (0.9* ImageWidth).toInt()
        Log.d("value",MainActivity.counted_objects.contains("100").toString())
        //middleBoundary = (0.5* ImageWidth).toInt()
        //passengers_in_count++


        //val mid = ((object_left_corner+object_right_corner)/2).toInt()

        //incoming
        if(MainActivity.incoming_passengers[tracking_id]?.get(0)== null)
        {
            //System.out.println("*****\ninitializing\n*******")
            MainActivity.incoming_passengers[tracking_id] = number

        }
        if(object_left_corner<middleBoundary)
        {
            MainActivity.incoming_passengers[tracking_id]?.set(0,1)
            //println(incoming_passengers[tracking_id]!![0])
            //System.out.println("someone is comming")

        }
        else if(object_left_corner > middleBoundary)
        {
            if(MainActivity.incoming_passengers[tracking_id]!![0]==1 && MainActivity.incoming_passengers[tracking_id]!![1]!=1)
            {

                if(SystemClock.uptimeMillis()-MainActivity.counting_delay>delay)
                {
                    MainActivity.incoming_passengers[tracking_id]?.set(1,1)
                    MainActivity.passengers_in_count++
                    //MainActivity.counted_objects.add(tracking_id)
                }
//                Log.d("counting_offset",
//                    (SystemClock.uptimeMillis()-MainActivity.counting_delay).toString()
//                )
                MainActivity.counting_delay= SystemClock.uptimeMillis()
                MainActivity.outgoing_passengers.remove(tracking_id)



//                if(MainActivity.counted_objects.contains(tracking_id) == false )
//                {
//                    MainActivity.passengers_in_count++
//                    MainActivity.counted_objects.add(tracking_id)
//                    if(tracking_id.toInt()>MainActivity.largestID)
//                        MainActivity.largestID=tracking_id.toInt()
//
//                }
                //System.out.println("someone got in"
            }
            else{
                MainActivity.incoming_passengers.remove(tracking_id)
            }

        }


        if(MainActivity.counted_objects.contains(tracking_id) == true)
            return

        //out going
        if(MainActivity.outgoing_passengers[tracking_id]?.get(1)== null)
        {
            //System.out.println("*****\ninitializing\n*******")
            MainActivity.outgoing_passengers[tracking_id] = number

        }
        if(object_right_corner > middleBoundary)// && object_right_corner <rightBoundary)
        {
            MainActivity.outgoing_passengers[tracking_id]?.set(1,1)
            //println(incoming_passengers[tracking_id]!![0])

        }
        else if(object_right_corner < middleBoundary)//object_right_corner>leftBoundary &&
        {
            if(MainActivity.outgoing_passengers[tracking_id]!![1]==1 && MainActivity.outgoing_passengers[tracking_id]!![0]!=1 )
            {


                if(SystemClock.uptimeMillis()-MainActivity.counting_delay>delay)
                {
                    MainActivity.outgoing_passengers[tracking_id]?.set(0,1)
                    MainActivity.passengers_out_count++
                    MainActivity.incoming_passengers.remove(tracking_id)
                    Log.d("counting_offset",(SystemClock.uptimeMillis()-MainActivity.counting_delay).toString())

                }
//                Log.d("counting_delay",
//                    (SystemClock.uptimeMillis()-MainActivity.counting_delay).toString()
//                )
                MainActivity.counting_delay= SystemClock.uptimeMillis()



//                if( tracking_id.toInt() > MainActivity.largestID && MainActivity.counted_objects.contains(tracking_id) == false)
//                {
//                    MainActivity.passengers_out_count++
//                    MainActivity.counted_objects.add(tracking_id)
//                }

            }
            else{
                MainActivity.outgoing_passengers.remove(tracking_id)
            }

        }



    }
}
