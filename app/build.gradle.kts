plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    // id("kotlin-kapt")
    alias(libs.plugins.kotlin.kapt)
    //id("com.google.dagger.hilt.android")
    alias(libs.plugins.dagger.hilt)
    alias(libs.plugins.safeargs)
}

android {
    namespace = "com.andres_sagadoc.horoscoapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.andres_sagadoc.horoscoapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            resValue("string", "nameapp", "Horoscope App")
            buildConfigField("String", "BASE_URL", "\"https://newastro.vercel.app\"")
        }
        getByName("debug") {
            isDebuggable = true
            resValue("string", "nameapp", "[DEBUG] - Horoscope App")
            buildConfigField("String", "BASE_URL", "\"https://newastro.vercel.app\"")

        }

    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.logging.interceptor)

    // DaggerHilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    // Navigation Component
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}