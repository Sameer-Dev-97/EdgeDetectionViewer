apply plugin: 'com.android.library'
apply plugin: 'kotlin-android'

android {
    // 1. ADDED NAMESPACE (Fixes modern Android Studio errors)
    namespace 'org.opencv'

    // 2. UPDATED SDK VERSIONS (To match your app)
    compileSdkVersion 34

    defaultConfig {
        minSdkVersion 24
        targetSdkVersion 34
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_17
                targetCompatibility JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = '17'
    }
}

dependencies {
    implementation 'androidx.core:core-ktx:1.12.0'
    implementation 'androidx.appcompat:appcompat:1.6.1'
}