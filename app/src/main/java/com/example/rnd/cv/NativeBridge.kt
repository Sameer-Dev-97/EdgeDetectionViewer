package com.example.rnd.cv

class NativeBridge {

    // Load the native libraries when this class is accessed
    companion object {
        init {
            System.loadLibrary("rndapp")
        }
    }

    /**
     * Native method to process the frame.
     * inputAddr: Memory address of the input Mat (Image)
     * outputAddr: Memory address where the result will be stored
     */
    external fun processFrame(inputAddr: Long, outputAddr: Long)
}