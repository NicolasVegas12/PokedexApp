
plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    google()
    maven("https://www.jitpack.io")
}

dependencies {
    implementation("com.android.tools.build:gradle:8.7.3")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.10")
    implementation("org.jetbrains.kotlin:kotlin-serialization:2.0.10")
    implementation ("com.squareup:javapoet:1.13.0")
}
