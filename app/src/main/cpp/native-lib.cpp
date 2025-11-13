#include <jni.h>
#include <string>
#include <opencv2/opencv.hpp>
#include <android/log.h>

#define LOG_TAG "NativeOpenCV"
#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG, LOG_TAG, __VA_ARGS__)

extern "C" JNIEXPORT void JNICALL
Java_com_example_rnd_cv_NativeBridge_processFrame(
        JNIEnv* env,
        jobject /* this */,
        jlong matAddrInput,
        jlong matAddrOutput) {

    // 1. Get the input and output matrices from the memory addresses
    cv::Mat& src = *(cv::Mat*)matAddrInput;
    cv::Mat& dst = *(cv::Mat*)matAddrOutput;

    if (src.empty()) return;

    try {
        cv::Mat gray, edges;

        // 2. Convert input to Grayscale (Canny requires single channel)
        // Check if input is already gray or BGRA/RGBA
        if (src.channels() == 4) {
            cv::cvtColor(src, gray, cv::COLOR_RGBA2GRAY);
        } else if (src.channels() == 3) {
            cv::cvtColor(src, gray, cv::COLOR_BGR2GRAY);
        } else {
            gray = src; // Already gray
        }

        // 3. Apply Canny Edge Detection
        // Thresholds: 50 (low), 150 (high)
        cv::Canny(gray, edges, 50, 150);

        // 4. Convert back to RGBA for display on Android screen
        cv::cvtColor(edges, dst, cv::COLOR_GRAY2RGBA);

    } catch (const cv::Exception& e) {
        LOGD("OpenCV Error: %s", e.what());
    }
}