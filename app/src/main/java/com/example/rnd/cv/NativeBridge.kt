package com.example.rnd.cv

class NativeBridge {

    // Load the native libraries when this class is accessed
    companion object {
        init {
            System.loadLibrary("rndapp")
        }
    }


    external fun processFrame(inputAddr: Long, outputAddr: Long)
}