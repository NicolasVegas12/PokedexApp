// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(libs.plugins.android.application.get().pluginId) apply false
    id(libs.plugins.android.library.get().pluginId) apply false
    id(libs.plugins.kotlin.android.get().pluginId) apply false

    libs.plugins.kotlin.compose.get().let {
        id(it.pluginId) version it.version.displayName apply false
    }

    id("org.sonarqube") version "6.0.1.5171"

    libs.plugins.android.google.services.get().let {
        id(it.pluginId) version it.version.displayName apply false
    }

    libs.plugins.androidx.ksp.get().let {
        id(it.pluginId) version it.version.displayName apply false
    }
    libs.plugins.dagger.hilt.get().let {
        id(it.pluginId) version it.version.displayName apply false
    }
}