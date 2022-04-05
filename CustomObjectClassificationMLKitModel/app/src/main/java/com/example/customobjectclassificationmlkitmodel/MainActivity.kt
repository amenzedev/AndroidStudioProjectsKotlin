package com.example.customobjectclassificationmlkitmodel

import android.annotation.SuppressLint
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.util.Size
import android.widget.TextView
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.core.view.children
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import com.example.customobjectclassificationmlkitmodel.databinding.ActivityMainBinding
import com.example.customobjectclassificationmlkitmodel.utils.Draw
import com.google.common.util.concurrent.ListenableFuture
import com.google.mlkit.common.model.LocalModel
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.objects.ObjectDetection
import com.google.mlkit.vision.objects.ObjectDetector
import com.google.mlkit.vision.objects.custom.CustomObjectDetectorOptions
import java.util.HashMap

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var objectDetector : ObjectDetector
    private lateinit var cameraProviderFuture: ListenableFuture<ProcessCameraProvider>
    private lateinit var textview: TextView

    var width=0
    var height=0
    var incoming_passengers = HashMap<String, IntArray>()
    var outgoing_passengers = HashMap<String, IntArray>()
    var passengers_in_count =0
    var passengers_out_count = 0
    var boundary = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        width = displayMetrics.widthPixels
        height = displayMetrics.heightPixels
        boundary = width/2

        //println(width)
        //println(height)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        textview = findViewById(R.id.textView4) as TextView
        textview.setText("Hello")

        cameraProviderFuture = ProcessCameraProvider.getInstance(this)
        cameraProviderFuture.addListener({
            val cameraProvider = cameraProviderFuture.get()

            //Bind camera provider
            bindPreview(cameraProvider = cameraProvider)
        }, ContextCompat.getMainExecutor(this))

        val localModel = LocalModel.Builder()
            .setAssetFilePath("object_detection.tflite")
            //.setAssetFilePath("object_detection_2.tflite")
            // or .setAbsoluteFilePath(absolute file path to model file)
            // or .setUri(URI to model file)
            .build()

        // Live detection and tracking
        val customObjectDetectorOptions =
            CustomObjectDetectorOptions.Builder(localModel)
                .setDetectorMode(CustomObjectDetectorOptions.STREAM_MODE)
                .enableClassification()
                .setClassificationConfidenceThreshold(0.5f)
                .setMaxPerObjectLabelCount(3)
                .build()

        objectDetector =
            ObjectDetection.getClient(customObjectDetectorOptions)

    }

    @SuppressLint("UnsafeOptInUsageError")
    private fun bindPreview(cameraProvider: ProcessCameraProvider)
    {
        val preview = Preview.Builder().build()

        val cameraSelector = CameraSelector.Builder()
            .requireLensFacing(CameraSelector.LENS_FACING_BACK)
            .build()

        preview.setSurfaceProvider(binding.previewView.surfaceProvider)

        val imageAnalysis = ImageAnalysis.Builder()
            .setTargetResolution(Size(1280,720))
            .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
            .build()

        imageAnalysis.setAnalyzer(ContextCompat.getMainExecutor(this),{ imageProxy ->

            val rotationDegrees = imageProxy.imageInfo.rotationDegrees

            val image = imageProxy.image


            if(image != null)
            {
                val processImage = InputImage.fromMediaImage(image,rotationDegrees)
                objectDetector
                    .process(processImage)
                    .addOnSuccessListener { objects ->
                        //println(objects)
                        for (i in objects){
                            if(binding.parentLayout.childCount > 1) binding.parentLayout.removeViewAt(1)

                            val trackingId = i.trackingId
                            if (trackingId != null) {
                                update_passenger_count(trackingId, i.boundingBox.left,i.boundingBox.right)
                            }
                            val label = i.labels.firstOrNull()?.text +" : "+trackingId?: "Undefined"
                            if(label != "Undefined" && label.contains("Person",ignoreCase = true))
                            {
                                val element = Draw(context = this, rect = i.boundingBox,text = i.labels.firstOrNull()?.text +" : "+trackingId?: "Undefined ",dimension_width = width,dimension_height = height, in_count = passengers_in_count, out_count = passengers_out_count)
                                binding.parentLayout.addView(element)
                            }
                            else{
                                val score = Draw(context = this, rect = Rect(0,0,0,0),text = "",dimension_width = width,dimension_height = height, in_count = passengers_in_count, out_count = passengers_out_count)
                                binding.parentLayout.addView(score)
                            }

                        }


                        imageProxy.close()
                        //println("******\nSuccess\n*****")
                    }.addOnFailureListener{
                        Log.v("MainActivity", "Error -${it.message}")

                        val score = Draw(context = this, rect = Rect(0,0,0,0),text = "",dimension_width = width,dimension_height = height, in_count = passengers_in_count, out_count = passengers_out_count)
                        binding.parentLayout.addView(score)

                        imageProxy.close()
                    }
            }
        })

        cameraProvider.bindToLifecycle(this as LifecycleOwner, cameraSelector,imageAnalysis,preview)

    }


    fun update_passenger_count(track_id:Int, object_left_corner:Int, object_right_corner:Int)
    {
        val number = IntArray(2)
        number[0]=0
        number[1]=0
        val tracking_id = track_id.toString()
        //incoming
        if(incoming_passengers[tracking_id]?.get(0)== null)
        {
            //System.out.println("*****\ninitializing\n*******")
            incoming_passengers[tracking_id] = number

        }
        else if(object_left_corner < boundary)
        {
            incoming_passengers[tracking_id]?.set(0,1)
            //println(incoming_passengers[tracking_id]!![0])

        }
        else if(object_left_corner > boundary)
        {
            if(incoming_passengers[tracking_id]!![0]==1)
            {
                passengers_in_count++
                incoming_passengers.remove(tracking_id)
            }

        }


        //out going
        if(outgoing_passengers[tracking_id]?.get(1)== null)
        {
            //System.out.println("*****\ninitializing\n*******")
            outgoing_passengers[tracking_id] = number

        }
        else if(object_right_corner > boundary)
        {
            outgoing_passengers[tracking_id]?.set(1,1)
            //println(incoming_passengers[tracking_id]!![0])

        }
        else if(object_right_corner  < boundary)
        {
            if(outgoing_passengers[tracking_id]!![1]==1)
            {
                passengers_out_count++
                outgoing_passengers.remove(tracking_id)
            }

        }



    }


}