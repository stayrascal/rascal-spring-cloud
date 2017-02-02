#!/bin/sh

cd $(dirname $0)

# Build docker base image
./base-image/docker.sh

# Build api-provider image
./api-provider/docker.sh

# Build api-consumer image
./api-consumer/docker.sh

# Build api-admin image
./api-admin/docker.sh

# Build api-gateway image
./api-gateway/docker.sh


# Clean docker dangling images
docker rmi $(docker images -f "dangling=true" -q)