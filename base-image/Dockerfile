FROM stayrascal/ubuntu
MAINTAINER stayrascal

WORKDIR /apps

COPY files/jdk-8u111-linux-x64.tar.gz /apps/docker/java8.tar.gz
COPY files/filebeat-5.1.2-linux-x86_64.tar.gz /apps/docker/filebeat.tgz

ENV JAVA_HOME /apps/java8

ADD install.sh /apps/docker/install.sh
RUN chmod u+x /apps/docker/install.sh && /apps/docker/install.sh