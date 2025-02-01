// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.google.devtools.ksp) apply false
    alias(libs.plugins.hilt) apply false
    kotlin("plugin.serialization") version "1.9.0" apply false
}

buildscript{
    dependencies {
        classpath(libs.secrets.gradle.plugin)
    }
}