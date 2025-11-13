cmake_minimum_required(VERSION 3.22.1)

project("rndapp")

# FIXED PATH (Using forward slashes):
set(OpenCV_DIR "C:/Users/Sameer/OpenCV-android-sdk/sdk/native/jni")

find_package(OpenCV REQUIRED)
include_directories(${OpenCV_INCLUDE_DIRS})

add_library(rndapp SHARED native-lib.cpp)

target_link_libraries(
        rndapp
        ${OpenCV_LIBS}
        android
        log
        GLESv2
        EGL)