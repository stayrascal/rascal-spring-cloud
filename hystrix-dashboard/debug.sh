#!/bin/bash

./gradlew bootRun -Dorg.gradle.jvmargs="-Xdebug -Xrunjdwp:transport=dt_socket,address=9090,server=y,suspend=y"
