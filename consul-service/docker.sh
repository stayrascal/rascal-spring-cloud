#!/bin/sh

cd $(dirname $0)

docker build -f Dockerfile -t stayrascal/global-config:latest .