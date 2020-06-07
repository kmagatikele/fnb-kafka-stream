##FROM abh1nav/java7
FROM phusion/baseimage:0.9.15


MAINTAINER Keletso Moselakgomo

RUN \
   echo "##############################"; \
   echo "UPGRADING AND INSTALLING WGET"; \
   echo "##############################"; \
   export http_proxy="http://10.0.17.109:3129/"; \
   export https_proxy="https://10.0.17.109:3129/"; \
   apt-get update; apt-get upgrade -y -qq; \
   apt-get install -y -qq wget sysstat; \
   apt-get clean && rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*


#######################################################################
## DOWNLOADING ORACLE JAVA 8
#####################################################################
RUN \
  wget --no-check-certificate --no-cookies --header "Cookie: oraclelicense=accept-securebackup-cookie" http://download.oracle.com/otn-pub/java/jdk/8u77-b03/server-jre-8u77-linux-x64.tar.gz \
  && mkdir /opt/java \
  && mv server-jre-8u77-linux-x64.tar.gz /opt/java/ \
  && ls -al /opt/java/


##################################################################
## INSTALLING JAVA 8
################################################################
RUN set -x \
  && cd /opt/java/ \
  && ls -al \
  && tar -zxf server-jre-8u77-linux-x64.tar.gz \
  && rm server-jre-8u77-linux-x64.tar.gz \
  && ls -al /opt/java/ \
  && update-alternatives --install /usr/bin/java java /opt/java/jdk1.8.0_77/bin/java 1 \
  && update-alternatives --display java \
  && java -version \
  && update-alternatives --set java /opt/java/jdk1.8.0_77/bin/java

# setup Data streaming application
#############################################################################

COPY app /opt/app

WORKDIR /opt/app/

CMD ["/bin/bash","/opt/app/startclient.sh"]

# Clean up
RUN apt-get remove --purge wget -y
RUN apt-get clean && rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*
