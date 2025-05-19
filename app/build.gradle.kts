plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.0"
}
kotlin {
    jvmToolchain(24) // Use JVM 17
}

android {
    compileSdk = 34
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17 // Keep 17 or change to VERSION_21 if needed
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17" // OR "21" based on what Compose supports
    }
    defaultConfig {
        applicationId = "com.example.interviewhelper"
        namespace="com.example.interviewhelper"
        minSdk = 21
        targetSdk = 34
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

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.10" // Add the correct version here
        kotlinCompilerVersion = "2.0.0" // Use the Kotlin version you're using
    }

    buildFeatures {
        compose = true
    }

    packagingOptions {
        resources.excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
}

dependencies {
    implementation("androidx.compose.ui:ui:1.6.1")
    implementation("androidx.activity:activity-compose:1.8.1")
    implementation("androidx.compose.material3:material3:1.2.0-alpha03")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    implementation("androidx.compose.runtime:runtime-livedata:1.6.1")  // Added for LiveData integration
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.8.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.7")// For testing Compose UI
}









