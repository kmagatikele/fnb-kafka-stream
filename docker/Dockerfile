##FROM abh1nav/java7
FROM openjdk:8-jre-alpine

RUN mkdir -p /opt/app

WORKDIR /opt/app

COPY app /opt/app

ENTRYPOINT ["./startclient.sh"]


# FROM openjdk:8-jre-alpine
#
# MAINTAINER Keletso Moselakgomo
#
#
# # setup Data streaming application
# #############################################################################
#
# COPY app /opt/app
#
# WORKDIR /opt/app/
#
# CMD ["/bin/bash","/opt/app/startclient.sh"]
#
# # RUN \
# #    echo "##############################"; \
# #    echo "UPGRADING AND INSTALLING WGET"; \
# #    echo "##############################"; \
# #    apt-get update; apt-get upgrade -y -qq; \
# #    apt-get install -y -qq wget sysstat; \
# #    apt-get clean && rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*
# #
# #
# # # #######################################################################
# # # ## DOWNLOADING ORACLE JAVA 8
# # # #####################################################################
# # # RUN \
# # #   wget --no-cookies --no-check-certificate --header "Cookie: gpw_e24=http%3a%2F%2Fwww.oracle.com%2Ftechnetwork%2Fjava%2Fjavase%2Fdownloads%2Fjdk8-downloads-2133151.html; oraclelicense=accept-securebackup-cookie;" "https://download.oracle.com/otn-pub/java/jdk/8u191-b12/2787e4a523244c269598db4e85c51e0c/jdk-8u191-linux-x64.tar.gz" \
# # #   && mkdir /opt/java \
# # #   && mv server-jre-8u77-linux-x64.tar.gz /opt/java/ \
# # #   && ls -al /opt/java/
# #
# #
# # ##################################################################
# # ## INSTALLING JAVA 8
# # ##################################################################
# # # RUN set -x \
# # #   && cd /opt/java/ \
# # #   && ls -al \
# # #   && tar -zxf server-jre-8u77-linux-x64.tar.gz \
# # #   && rm server-jre-8u77-linux-x64.tar.gz \
# # #   && ls -al /opt/java/ \
# # #   && update-alternatives --install /usr/bin/java java /opt/java/jdk1.8.0_77/bin/java 1 \
# # #   && update-alternatives --display java \
# # #   && java -version \
# # #   && update-alternatives --set java /opt/java/jdk1.8.0_77/bin/java
# #
# #
# # # Install OpenJDK-8
# # RUN apt-get update && \
# #     apt-get install -y openjdk-8-jre-headless && \
# #     apt-get install -y ant && \
# #     apt-get clean;
# #
# # # Fix certificate issues
# # RUN apt-get update && \
# #     apt-get install ca-certificates-java && \
# #     apt-get clean && \
# #     update-ca-certificates -f;
# #
# # # Setup JAVA_HOME -- useful for docker commandline
# # ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64/
# # RUN export JAVA_HOME
# #
# # # setup Data streaming application
# # #############################################################################
# #
# # COPY app /opt/app
# #
# # WORKDIR /opt/app/
# #
# # CMD ["/bin/bash","/opt/app/startclient.sh"]
# #
# # # Clean up
# # # RUN apt-get remove --purge wget -y
# # # RUN apt-get clean && rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*
