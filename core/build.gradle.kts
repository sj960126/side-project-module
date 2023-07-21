plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.core"
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
    implementation(project(":base"))
//
//    implementation("androidx.core:core-ktx:$core_ktx")
//    implementation("androidx.appcompat:appcompat:$appcompat")
//    implementation("androidx.annotation:annotation:$annotation")
//    implementation("com.google.android.material:material:$material")
//
//    // LifeCycleExtension && Kotlin extension
//    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$viewModel")
//    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$liveData")
//    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_runtime")
//    implementation("androidx.lifecycle:lifecycle-common-java8:$lifecycle_common")
//    implementation("androidx.fragment:fragment-ktx:$fragment")
//    implementation("androidx.activity:activity-ktx:$activity")
//
//    // RxJava2
//    implementation("io.reactivex.rxjava2:rxjava:$rxjava")
//    // RxAndroid
//    implementation("io.reactivex.rxjava2:rxandroid:$rxandroid")
//    // RxKotlin
//    implementation("io.reactivex.rxjava2:rxkotlin:$rxkotlin")
}