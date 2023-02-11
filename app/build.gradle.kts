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
    implementation(libs.bundles.compose)
    implementation(libs.bundles.composeUiTooling)
    implementation(libs.google.dagger.hiltAndroid)
    implementation(libs.androidx.activity.activityCompose)
    implementation(libs.androidx.appCompat)
    implementation(libs.androidx.hilt.hiltNavigationCompose)
    implementation(libs.androidx.navigation.navigationCompose)
    implementation(libs.coilKt.coil.compose)
    implementation(libs.jakes.timber.timber)
    implementation(libs.bundles.lifecycle)
    debugImplementation(libs.androidx.compose.ui.uiTest.manifest)

    //Hilt
    kapt (libs.androidx.hilt.hiltCompiler)
}