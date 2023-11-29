import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.21"
    kotlin("plugin.serialization") version "1.9.21"
    id("io.gitlab.arturbosch.detekt") version "1.23.4"
    `java-library`
    `maven-publish`
}

group = "com.rtarita.skull"
version = "1.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:1.7.2")
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

detekt {
    basePath = rootDir.toString()
}

publishing {
    publications {
        create<MavenPublication>("SkullgameCommon") {
            from(components["java"])
        }
    }
}
