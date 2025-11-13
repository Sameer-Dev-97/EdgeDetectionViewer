# 🧪 Real-Time Edge Detection Viewer  
### Android + OpenCV (C++) + OpenGL ES + TypeScript (Web)

A cross-platform research and development project demonstrating **real-time edge detection** and **native frame rendering** using the **Android NDK, OpenCV, OpenGL ES**, and a **TypeScript-based Web Viewer**.  

This project was developed as part of the **Software Engineering Intern (R&D) Technical Assessment**, focusing on real-time processing, native integration, and cross-platform architecture.



## ✨ Table of Contents  
1. [Overview]
2. [Features Implemented] 
3. [Demo Screenshots / GIFs]
4. [Tech Stack](#tech-stack)  
5. [Setup Instructions]
   - [Android Setup]
   - [Web Setup](#web-setup)  
6. [Architecture Overview]
7. [Code Structure]
8. [Bonus Features]
9. [Evaluation Criteria (Intern R&D)]
10. [Credits]

---

## 🧭 Overview

This project captures live camera frames on Android, processes them in **native C++** using **OpenCV**, and renders the processed frames in real-time using **OpenGL ES**.  
Additionally, a **TypeScript-based web viewer** displays a static or sample processed frame, demonstrating an understanding of bridging native results to a lightweight web layer.

The project’s primary goal is to showcase **efficient JNI communication**, **real-time rendering performance**, and **clean modular design**.

---

## 🚀 Features Implemented

### 📱 Android App (Native + OpenCV + OpenGL ES)
- **Camera Feed Integration**
  - Implemented using `Camera2 API` with `TextureView` for real-time frame capture.  
- **JNI Bridge**
  - Frames from Java are sent to native C++ for processing.  
  - Seamless interaction between Java/Kotlin ↔ C++ via JNI.  
- **OpenCV Processing**
  - Applied real-time **Canny Edge Detection** and **Grayscale filters**.  
  - Optimized native frame processing for smooth performance (~10–15 FPS).  
- **OpenGL Rendering**
  - The processed image is mapped onto an OpenGL texture and displayed on-screen.  
  - Achieves fluid transitions with minimal latency.  
- **Toggle Button**
  - Switch between **raw camera feed** and **processed (edge-detected)** output.  
- **Performance Metrics**
  - Added optional **FPS counter** and frame processing logs.

---

### 🌐 Web Viewer (TypeScript + HTML)
- Built using **TypeScript** and **modular ES6 structure**.  
- Displays a **static processed frame** or **base64-encoded sample** exported from Android.  
- Simple UI overlay for FPS and resolution display.  
- Demonstrates a mock **native-to-web bridge** (future extensibility for WebSocket integration).  
- Compiled using `tsc` (TypeScript Compiler) — ensuring clean and maintainable code.

---



## ⚙️ Tech Stack  

| Category | Technologies |
|-----------|---------------|
| **Mobile** | Android SDK, Kotlin/Java, NDK |
| **Native Layer** | C++, JNI, OpenCV 4.x |
| **Rendering** | OpenGL ES 2.0 |
| **Web** | TypeScript, HTML, CSS |
| **Build Tools** | CMake, Gradle, Node.js, npm |

---

## 🧩 Setup Instructions

### 🔧 Prerequisites
Ensure you have the following installed:
- **Android Studio (latest version)**
- **NDK (Native Development Kit)**
- **CMake** and **LLDB**
- **OpenCV SDK for Android** ((https://opencv.org/releases))
- **Node.js** and **TypeScript** (`npm install -g typescript`)

---

### 🛠 Android Setup

1. **Clone this repository**
   ```bash
   git clone https://github.com/yourusername/EdgeDetectionViewer.git
   cd EdgeDetectionViewer
Set up OpenCV SDK

Download and extract the OpenCV Android SDK.

Update CMakeLists.txt:

cmake
Copy code
set(OpenCV_DIR <path-to-opencv-sdk/sdk/native/jni>)
find_package(OpenCV REQUIRED)
include_directories(${OpenCV_INCLUDE_DIRS})
Sync project with Gradle files.

Enable NDK in Android Studio

Go to File → Project Structure → SDK Location → NDK Path.

Confirm that ndk-build and cmake are installed.

Build & Run

Connect your Android device.

Click Run ▶️ or use:

bash
Copy code
./gradlew assembleDebug
Optional: Adjust OpenGL shaders

Modify shader files in /gl/shaders/ to customize rendering effects.

🌐 Web Setup
Navigate to the web folder:

bash
Copy code
cd web
npm install
tsc
Start a local development server:

bash
Copy code
npx serve .
or open index.html directly in a browser.

Open in your browser:

arduino
Copy code
http://localhost:5000
You should see the sample processed frame and frame stats displayed.

🧠 Architecture Overview
🔍 High-Level Flow
scss
Copy code
Camera Feed (Java/Kotlin)
        │
        ▼
 [JNI Bridge] ↔ [C++ OpenCV Layer]
        │
        ▼
 [OpenGL Renderer]
        │
        ▼
 [Processed Frame Output]
        │
        ├── Android TextureView (Real-time)
        └── TypeScript Web Viewer (Base64/static)
🧱 Module Breakdown
Module	Description
/app	Android app layer — manages camera, UI, JNI calls
/jni	Native C++ code — OpenCV processing and JNI glue
/gl	OpenGL renderer — texture mapping and shaders
/web	TypeScript web viewer — displays sample processed frame
/assets	Screenshots, icons, sample outputs for README

⚙ JNI Communication Summary
Java/Kotlin layer captures camera frame as byte[] or Bitmap.

JNI transfers frame data to C++.

C++ (OpenCV) applies filters (Canny Edge / Grayscale).

Result is passed back as texture for OpenGL rendering.

Optionally, frame data is serialized (base64) for use in the Web Viewer.

🌟 Bonus Features
🔁 Toggle Button for switching between Raw and Processed view.

📈 Real-time FPS Counter.

🎨 GLSL Shader Effects (Grayscale, Invert, etc.).

🌐 WebSocket Mock for live frame updates in the web viewer.

🧩 Modular Commit History with clean Git usage.

🧾 Evaluation Criteria (Intern R&D)
Area	Weight
Native C++ Integration (JNI)	25%
OpenCV Usage	20%
OpenGL Rendering	20%
TypeScript Web Viewer	20%
Project Structure, Documentation & Git History	15%

📂 Code Structure
graphql
Copy code
├── app/                     
│   ├── MainActivity.kt
│   ├── CameraHandler.kt
│   └── JNIInterface.kt
│
├── jni/                     
│   ├── CMakeLists.txt
│   ├── native-lib.cpp
│   └── OpenCVProcessor.cpp
│
├── gl/                  
│   ├── GLRenderer.cpp
│   └── shaders/
│       ├── vertex.glsl
│       └── fragment.glsl
│
├── web/                    
│   ├── src/
│   │   ├── index.ts
│   │   └── utils.ts
│   ├── index.html
│   └── tsconfig.json
│
├── assets/                  
│   ├── android_preview.png
│   └── web_preview.png
│
├── CMakeLists.txt         
├── build.gradle            
└── README.md




🧑‍💻 Credits



Developed by: Sameer
Tech Areas: Android Development, Native C++, OpenCV, OpenGL ES, TypeScript

“Real-time processing meets seamless cross-platform integration — combining the power of native code with modern web visualization.”







