SkullGame Common

This repository contains common code that is shared between
the [SkullGame Server](https://github.com/RaphaelTarita/skullgame-server) and any potential client (for example the
[SkullGame CLI Client](https://github.com/RaphaelTarita/skullgame-client-cli)). If you want to run the server or some
client, you will first need to build this project and install it to your local maven repository. This is very
straightforward thanks to the [Gradle](https://gradle.org) build system that was used in this project.

### Building

In order to build this project and install it to your local maven repository, simply run `gradlew publishToMavenLocal` (
or `gradlew.bat publishToMavenLocal` on Windows). After this task has completed successfully, the other dependent
projects can be built.