#!/bin/bash

cd $(dirname $0)
DIR=$(pwd)

export JAR_FILE=$(cd build/libs && ls *.jar)
cd $DIR

docker build -f ./docker/Dockerfile -t stayrascal/api-provider:latest --build-arg jar=$JAR_FILE .