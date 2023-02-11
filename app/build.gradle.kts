plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.hilt)
}


android {
    compileSdk = 33

    defaultConfig {
        applicationId = "com.codingpizza.composerecipebook"

        minSdk = 26
        targetSdk = 33

        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.get()
    }

    packagingOptions {
        resources {
            excludes += "META-INF/AL2.0"
            excludes += "META-INF/LGPL2.1"
        }
    }


}

dependencies {
    val compose_version = "1.1.0"
    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.compose.ui:ui:$compose_version")
    implementation("androidx.compose.ui:ui-tooling-preview:$compose_version")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.1")
    implementation("androidx.activity:activity-compose:1.4.0")
    implementation("androidx.compose.material:material:$compose_version")
    implementation("io.coil-kt:coil-compose:1.4.0")


    //Hilt
    implementation ("com.google.dagger:hilt-android:2.41")
    kapt ("com.google.dagger:hilt-compiler:2.41")
    implementation ("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
    implementation ("androidx.hilt:hilt-navigation-compose:1.0.0")
    kapt ("androidx.hilt:hilt-compiler:1.0.0")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:$compose_version")
    debugImplementation ("androidx.compose.ui:ui-tooling:$compose_version")
    debugImplementation ("androidx.compose.ui:ui-test-manifest:$compose_version")
}