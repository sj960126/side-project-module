plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id ("maven-publish")
}

android {
    namespace = "com.module.core_data"
    compileSdkVersion(33)

    defaultConfig {
        minSdkVersion(24)
        targetSdkVersion(33)
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    // AndroidX-Core
    implementationAndroidXCore()

    // Retrofit, OkHttp, Gson
    implementationRetrofitOkHttp()

    // RxJava2
    implementationRxJava2()

    // lifeCycle
    implementationLifecycle()
    implementation(Dependencies.AndroidX.activity)
    implementation(Dependencies.AndroidX.fragment)

    // room
   implementationRoom()

    implementation(Dependencies.Android.extensions)

    // hlit
    implementationHilt()

    // Timber
    implementation(Dependencies.ThirdParty.timber)

}
