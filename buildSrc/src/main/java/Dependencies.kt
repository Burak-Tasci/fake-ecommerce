/**
 * Created by Burak Taşcı on 7.09.2022.
 */
object BuildPlugins {
    val android by lazy { "com.android.tools.build:gradle:${Versions.gradlePlugin}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}" }
    val hilt by lazy { "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}" }
    val navigation by lazy { "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}" }
}

object Dependencies {
    val core by lazy { "androidx.core:core-ktx:${Versions.core}" }
    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }
    val timber by lazy { "com.jakewharton.timber:timber:${Versions.timber}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}" }
    val materialDesign by lazy { "com.google.android.material:material:${Versions.material}" }
    val junit by lazy { "junit:junit:${Versions.jUnit}" }

    // Hilt
    val hiltAndroid by lazy { "com.google.dagger:hilt-android:${Versions.hilt}" }
    val hiltCompiler by lazy { "com.google.dagger:hilt-compiler:${Versions.hilt}" }

    // Coroutines
    val coroutinesCore by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}" }
    val coroutinesAndroid by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}" }
    val coroutinesPlayService by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:${Versions.coroutines}" }

    // Lifecycle
    val lifecycleLiveData by lazy { "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}" }
    val lifecycleViewModel by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}" }
    val lifecycleRuntime by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}" }

    // OkHttp
    val okhttpOkHttp by lazy { "com.squareup.okhttp3:okhttp:${Versions.okhttp}" }
    val okhttpLoggingInterceptor by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}" }

    // Retrofit
    val retrofitRetrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofit}" }
    val retrofitGsonConvertor by lazy { "com.squareup.retrofit2:converter-gson:${Versions.retrofit}" }

    // Navigation
    val navigationFragment by lazy { "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}" }
    val navigationUI by lazy { "androidx.navigation:navigation-ui-ktx:${Versions.navigation}" }

    // Fragment
    val fragment by lazy { "androidx.fragment:fragment-ktx:${Versions.fragment}" }

    // Glide
    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
}