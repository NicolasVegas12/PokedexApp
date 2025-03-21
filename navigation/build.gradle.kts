plugins {
    id(libs.plugins.android.library.get().pluginId)
    id(libs.plugins.kotlin.android.get().pluginId)
    id(libs.plugins.kotlin.compose.get().pluginId)
    kotlin(libs.plugins.jetbrains.kotlin.serialization.get().pluginId)
    id(libs.plugins.dagger.hilt.get().pluginId)
    id(libs.plugins.androidx.ksp.get().pluginId)
    id("org.sonarqube")
    `android-config`
}

android {
    namespace = "com.nvegas.navigation"
    buildFeatures.compose = true

}

dependencies {

    implementation(project(":common:core"))
    //Splash
    implementation(project(":splash:data"))
    implementation(project(":splash:presentation"))
    //Home Module
    implementation(project(":home:presentation"))
    implementation(project(":home:data"))

    //Sign In Module
    implementation(project(":signIn:presentation"))
    implementation(project(":signIn:data"))

    //Sign In Module
    implementation(project(":signUp:presentation"))
    implementation(project(":signUp:data"))

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