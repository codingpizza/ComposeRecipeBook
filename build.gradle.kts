buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
        classpath("com.android.tools.build:gradle:7.1.1")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.40.5")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}