plugins {
    id(libs.plugins.android.application.get().pluginId)
    id(libs.plugins.kotlin.android.get().pluginId)
    id(libs.plugins.kotlin.compose.get().pluginId)
    id(libs.plugins.dagger.hilt.get().pluginId)
    id(libs.plugins.androidx.ksp.get().pluginId)
    id("org.sonarqube")
    kotlin(libs.plugins.jetbrains.kotlin.serialization.get().pluginId)
    `android-config`
}

android {
    namespace = "com.nvegas.pokemoninterviewapp"
    defaultConfig {
        applicationId = "com.nvegas.pokemoninterviewapp"

        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {

    implementation(project(":navigation"))
    implementation(project(":common"))


    implementation(libs.bundles.android.compose.core)
    implementation(libs.bundles.android.compose.extensions)
    implementation(platform(libs.androidx.compose.bom))

    implementation(libs.bundles.dagger.hilt.compose)

    ksp(libs.bundles.dagger.hilt.compiler)


    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}