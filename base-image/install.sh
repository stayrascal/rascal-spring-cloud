#!/bin/sh

# JAVA
mkdir /apps/java8
tar -xzf /apps/docker/java8.tar.gz -C /apps/java8 --strip 1
rm -f /apps/docker/java8.tar.gz

# filebeat
mkdir /apps/filebeat
tar -xzf /apps/docker/filebeat.tgz -C /apps/filebeat --strip 1
rm -f /apps/docker/filebeat.tgz