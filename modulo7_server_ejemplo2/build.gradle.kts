val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
    application
    kotlin("jvm") version "1.8.22"
    kotlin("plugin.serialization") version "1.7.20"
    id("io.ktor.plugin") version "2.3.1"
    id("com.squareup.sqldelight") version "1.5.4"
}

group = "com.devexperto.kotlinexpert"
version = "0.0.1"

sqldelight {
    database("AppDatabase") {
        packageName = "com.devexperto.kotlinexpert.database"
    }
}

application {
    mainClass.set("com.devexperto.kotlinexpert.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-netty-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-html-builder:$ktor_version")
    implementation("io.ktor:ktor-server-content-negotiation:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")
    implementation("io.ktor:ktor-server-cors:$ktor_version")

    implementation("ch.qos.logback:logback-classic:$logback_version")

    implementation("com.squareup.sqldelight:sqlite-driver:1.5.4")

    testImplementation("io.ktor:ktor-server-tests-jvm:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}