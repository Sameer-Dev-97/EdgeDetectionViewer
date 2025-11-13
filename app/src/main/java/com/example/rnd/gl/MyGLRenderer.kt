package com.example.rnd.gl

import android.opengl.GLES20
import android.opengl.GLSurfaceView
import android.graphics.Bitmap
import com.example.rnd.cv.NativeBridge
import org.opencv.android.Utils
import org.opencv.core.Mat
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

class MyGLRenderer : GLSurfaceView.Renderer {

    private var inputMat: Mat? = null
    private var outputMat: Mat? = null

    // Bridge to C++
    private val nativeBridge = NativeBridge()

    // Textures
    private var textures = IntArray(1)
    private var frameBitmap: Bitmap? = null
    private var isNewFrameAvailable = false

    override fun onSurfaceCreated(gl: GL10?, config: EGLConfig?) {
        // Set background to black
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f)

        // Initialize mats
        inputMat = Mat()
        outputMat = Mat()

        // generate texture
        GLES20.glGenTextures(1, textures, 0)
    }

    override fun onSurfaceChanged(gl: GL10?, width: Int, height: Int) {
        GLES20.glViewport(0, 0, width, height)
    }

    override fun onDrawFrame(gl: GL10?) {
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT)

        if (isNewFrameAvailable && frameBitmap != null) {
            // 1. Convert Bitmap to OpenCV Mat
            Utils.bitmapToMat(frameBitmap, inputMat)

            // 2. Call Native C++ to do Edge Detection
            if (!inputMat!!.empty()) {
                // Ensure output mat matches size
                outputMat!!.create(inputMat!!.rows(), inputMat!!.cols(), inputMat!!.type())

                // JNI CALL
                nativeBridge.processFrame(inputMat!!.nativeObjAddr, outputMat!!.nativeObjAddr)

                // 3. Convert result back to Bitmap to display (Simplified rendering)
                // In a production pure-OpenGL app, we would bind outputMat data directly to a texture.
                // For this assignment, swapping the bitmap back is safer to avoid complex GL byte alignment bugs.
                Utils.matToBitmap(outputMat, frameBitmap)
            }

            isNewFrameAvailable = false
        }

        // TODO: Here we would draw the 'frameBitmap' to a Texture Quad.
        // For now, we will ensure the processing loop works.
    }

    fun updateFrame(bitmap: Bitmap) {
        this.frameBitmap = bitmap
        this.isNewFrameAvailable = true
    }
}