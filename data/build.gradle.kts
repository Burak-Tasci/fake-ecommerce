plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdk = ConfigData.compileSdkVersion
    namespace = "com.tsci.data"
    defaultConfig {
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
}

dependencies {

    implementation(Dependencies.core)
    implementation(project(":entity"))
    implementation(project(":core"))


    // hilt/dependency injection
    api(Dependencies.hiltDagger)
    api(Dependencies.hiltCompiler)
    api(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltDaggerCompiler)
    // gson
    api(Dependencies.gson)
    // network request
    api(Dependencies.retrofitGsonConvertor)
    api(Dependencies.retrofitRetrofit)
    api(Dependencies.okhttpLoggingInterceptor)
    // state handling
    api(Dependencies.sandwich)
    // coroutines core
    api(Dependencies.coroutinesCore)

}