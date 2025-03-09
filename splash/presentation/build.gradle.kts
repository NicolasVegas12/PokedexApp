plugins {
    id(libs.plugins.android.library.get().pluginId)
    id(libs.plugins.kotlin.android.get().pluginId)
    id(libs.plugins.kotlin.compose.get().pluginId)
    kotlin(libs.plugins.jetbrains.kotlin.serialization.get().pluginId)
    id(libs.plugins.dagger.hilt.get().pluginId)
    id("org.sonarqube")
    id(libs.plugins.androidx.ksp.get().pluginId)
    `android-config`
}

android {
    namespace = "com.nvegas.splash.presentation"
    buildFeatures.compose = true

}

dependencies {

    implementation(project(":common"))

    implementation(libs.bundles.android.compose.core)
    implementation(libs.bundles.android.compose.extensions)

    implementation(libs.bundles.dagger.hilt.compose)

    ksp(libs.bundles.dagger.hilt.compiler)

    implementation(libs.bundles.serialization)


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}