import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.0"
    kotlin("plugin.serialization") version "1.9.0"
    `java-library`
    `maven-publish`
}

group = "com.rtarita.skull"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")
}

kotlin {
    explicitApi()
}

java {
    withSourcesJar()
}

tasks.withType<KotlinCompile>().all {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
    }
}

publishing {
    publications {
        create<MavenPublication>("SkullgameCommon") {
            from(components["java"])
        }
    }
}