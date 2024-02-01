# SkullGame Common

This repository contains common code that is shared between
the [SkullGame Server](https://github.com/RaphaelTarita/skullgame-server) and any potential client (for example the
[SkullGame CLI Client](https://github.com/RaphaelTarita/skullgame-client-cli)). If you want to run the server or some
client, you will first need to build this project and install it to your local maven repository. This is very
straightforward thanks to the [Gradle](https://gradle.org) build system that was used in this project.

### Building

In order to build this project and install it to your local maven repository, simply run `gradlew publishToMavenLocal` (
or `gradlew.bat publishToMavenLocal` on Windows). After this task has completed successfully, the other dependent
projects can be built.

### Multiplatform

#### Targets

The following targets are supported by this library:

- Kotlin/JVM
- Kotlin/JS
    - Browser
    - NodeJS
- Kotlin/WASM
    - Browser
    - NodeJS
- Kotlin/Native
    - mingwX64
    - linuxX64
    - linuxArm64
    - androidNativeArm32
    - androidNativeArm64
    - androidNativeX86
    - androidNativeX64
    - iosArm64 *
    - iosSimulatorArm64 *
    - iosX64 *
    - macosX64 *
    - macosArm64 *
    - watchosX64 *
    - watchosArm32 *
    - watchosArm64 *
    - watchosSimulatorArm64 *
    - watchosDeviceArm64 *
    - tvosX64 *
    - tvosArm64 *
    - tvosSimulatorArm64 *

#### Kotlin/JVM

The Kotlin/JVM target is configured with JVM version 17 as its target.

#### Kotlin/JS and Kotlin/WASM

Gradle's automatic download of NodeJS is disabled (due to issues on Linux), so you need a working NodeJS installation on
your system and in your path in order to build this library.

#### Kotlin/WASM

Please be aware that as of the last update of this library, Kotlin/WASM is still in alpha. Everything about this target
is subject to change without warning, and this also translates to this library.

#### Kotlin/Native Apple targets

They should work in theory but building of this library has only been tested on Windows and Linux, and all apple-related
targets can only be build on a MacOS machine. The targets marked with * could not be verified by me.

#### Android

This library is not configured as an android library because it does not interact with android in any way. It supports
JVM, though, so it can be used in android projects.