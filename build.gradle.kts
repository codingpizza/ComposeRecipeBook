import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.kapt) apply false
}

subprojects {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }

    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions {
            freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"
            freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlinx.coroutines.ExperimentalCoroutinesApi"
            jvmTarget = JavaVersion.VERSION_11.toString()
        }
    }
}