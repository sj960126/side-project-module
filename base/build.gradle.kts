plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdkVersion (31)
    namespace = "com.module.base"

    defaultConfig {
        minSdkVersion (24)
        targetSdkVersion (31)
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

}

dependencies {

    // AndroidX-Core
    implementationAndroidXCore()
    
    // RxJava2
    implementationRxJava2()

    // lifeCycle
    implementationLifecycle()
    implementation(Dependencies.AndroidX.activity)
    implementation(Dependencies.AndroidX.fragment)

    implementation(Dependencies.ThirdParty.commonsIo)
    implementation(Dependencies.Android.extensions)

}

