plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = "com.module.base"
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.compileSdkVersion
        versionCode = 1
        versionName = "1.0"
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

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":base"))
    implementation(project(":core"))

    // AndroidX-Core
    implementationAndroidXCore()

    // Glide
    implementationGlide()

    // Picasso
    implementation(Dependencies.SquareUp.picasso)

    // 파이어베이스
    implementationFirebase()

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

    implementation(Dependencies.ThirdParty.commonsIo)
    implementation(Dependencies.ThirdParty.lottie)

    implementation(Dependencies.Android.extensions)

    testImplementation(Dependencies.junit)
    testImplementation(Dependencies.kotlinxCoroutinesTest)
    testImplementation(Dependencies.AndroidX.coreTesting)
    testImplementation(Dependencies.mockk)

    // hlit
    implementationHilt()

}
