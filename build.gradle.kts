//buildscript {
//    dependencies {
//        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.0")
//    }
//}

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    kotlin("plugin.serialization") version "2.0.0" apply false
    //id("org.jetbrains.kotlin.plugin.serialization") version "1.7.20" apply false
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.compose.compiler) apply false
}