# README #

This README would normally document whatever steps are necessary to get your application up and running.

### What is this repository for? ###

* Quick summary
* Version
* [Learn Markdown](https://bitbucket.org/tutorials/markdowndemo)

### Steps to Run this Application

#### Run Kafka On Docker 
1. Install Docker on Your Machine
2. 

#####Build Image
docker build -t fnb-kafka-stream .

#####Run Images
docker run -d -e KAFKAENDPOINT=10.0.20.35:9094 -e KAFKATOPIC=keletso-test -e KAFKAGROUPID=keletso-con --name fnb-stream fnb-kafka-stream:latest