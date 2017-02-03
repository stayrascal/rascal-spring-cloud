FROM ubuntu:16.04
MAINTAINER stayrascal

COPY files/wait-for-it.sh /apps/docker/wait-for-it.sh

ADD install.sh /apps/docker/install.sh
RUN chmod u+x /apps/docker/wait-for-it.sh
RUN chmod u+x /apps/docker/install.sh && /apps/docker/install.sh