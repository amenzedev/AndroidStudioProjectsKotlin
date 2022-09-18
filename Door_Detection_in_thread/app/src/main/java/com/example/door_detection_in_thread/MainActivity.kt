package com.example.door_detection_in_thread

import ObjectDetectorHelper
import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.util.Size
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import com.example.door_detection_in_thread.databinding.ActivityMainBinding
import com.google.common.util.concurrent.ListenableFuture
import org.tensorflow.lite.support.image.ImageProcessor
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.support.image.ops.Rot90Op
import org.tensorflow.lite.task.core.BaseOptions
import org.tensorflow.lite.task.vision.detector.Detection
import org.tensorflow.lite.task.vision.detector.ObjectDetector



class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private var objectDetector: ObjectDetector? = null
    private lateinit var cameraProviderFuture: ListenableFuture<ProcessCameraProvider>
    private lateinit var objectDetectorHelper: ObjectDetectorHelper
    private lateinit var bitmapBuffer: Bitmap

    companion object{
        var door_result: List<Detection>? =null
    }





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        cameraProviderFuture = ProcessCameraProvider.getInstance(this)
        cameraProviderFuture.addListener({
            val cameraProvider = cameraProviderFuture.get()
            //Bind camera provider
            bindPreview(cameraProvider = cameraProvider)

        }, ContextCompat.getMainExecutor(this))

//        objectDetectorHelper = ObjectDetectorHelper(
//            context = this,
//            objectDetectorListener = this)

    }

    @SuppressLint("UnsafeOptInUsageError")
    private fun bindPreview (cameraProvider: ProcessCameraProvider){
        val preview = Preview.Builder().build()
        val cameraSelector = CameraSelector.Builder()
            .requireLensFacing(CameraSelector.LENS_FACING_BACK)
            .build()
        preview.setSurfaceProvider(binding.previewView.surfaceProvider)

//        val imageAnalysis = ImageAnalysis.Builder()
//            .setTargetResolution(Size(1280,720))
//            .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
//            .build()
        val imageAnalysis = ImageAnalysis.Builder()
            .setTargetAspectRatio(AspectRatio.RATIO_4_3)
            .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
            .setOutputImageFormat(ImageAnalysis.OUTPUT_IMAGE_FORMAT_RGBA_8888)
            .build()
            // The analyzer can then be assigned to the instance
            imageAnalysis.setAnalyzer(ContextCompat.getMainExecutor(this)) { image ->
                    if (true) {
                        // The image rotation and RGB image buffer are initialized only once
                        // the analyzer has started running
                        bitmapBuffer = Bitmap.createBitmap(
                            image.width,
                            image.height,
                            Bitmap.Config.ARGB_8888
                        )
                    }

                    detectObjects(image)
                }
            //Must unbind the use-cases before rebinding then
            cameraProvider.unbindAll()


//        imageAnalysis.setAnalyzer(ContextCompat.getMainExecutor(this),{imageProxy ->
//
//            bitmapBuffer = Bitmap.createBitmap(
//                imageProxy.width,
//                imageProxy.height,
//                Bitmap.Config.ARGB_8888
//            )
//            detectObjects(imageProxy)
//            Log.v("MainActivity","the result is - ${door_result}")
//
//            val rotationDegres = imageProxy.imageInfo.rotationDegrees
//            val image = imageProxy.image
//
//
//            if(image != null)
//            {
//                //val processImage = InputImage.fromMediaImage(image,rotationDegres)
//                //door_detector(imageProxy,rotationDegres)
//                imageProxy.close()
//
//
//            }
//        })

        //cameraProvider.bindToLifecycle(this as LifecycleOwner,cameraSelector,imageAnalysis,preview)
        try {
            cameraProvider.bindToLifecycle(this as LifecycleOwner,cameraSelector,imageAnalysis,preview)
        } catch (exc: Exception) {
            Log.v("MainActivity","failed")
        }

    }


    private fun detectObjects(image: ImageProxy) {
        bitmapBuffer = Bitmap.createBitmap(
            image.width,
            image.height,
            Bitmap.Config.ARGB_8888
        )
        Log.v("MainActivity","the result is - ${image.planes[0].buffer}")
        // Copy out RGB bits to the shared bitmap buffer
        image.use { bitmapBuffer.copyPixelsFromBuffer(image.planes[0].buffer) }

        val imageRotation = image.imageInfo.rotationDegrees
        // Pass Bitmap and rotation to the object detector helper for processing and detection
        objectDetectorHelper.detect(bitmapBuffer, imageRotation)
    }


}