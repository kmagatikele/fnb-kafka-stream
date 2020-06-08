# README #

This README would normally document whatever steps are necessary to get your application up and running.

### Steps to Run this Application

#### Run Kafka On Docker 
1. Install Docker on Your Machine
2. Create docker network 
```
docker network create app-tier --driver bridge
```
3. Run Zookeeper
```
docker run -d --name zookeeper --network app-tier -e ALLOW_ANONYMOUS_LOGIN=yes -p 2181:2181 bitnami/zookeeper:late
```
4. Run Kafka Node

```
docker run -d --name kafka1 --network app-tier -e KAFKA_CFG_ZOOKEEPER_CONNECT=zookeeper:2181 -e ALLOW_PLAINTEXT_LISTENER=yes -e KAFKA_MESSAGE_MAX_BYTES=2000000 -p 9092:9092 bitnami/kafka:latest
```

### Run Stream Application
1. Login to my docker hub 
```
docker login --username=keletsoox --password=keletso1993
```
2. Run Application on Docker  
```
docker run -d -e KAFKAENDPOINT=localhost:9094 -e KAFKATOPIC=pub-original-tran -e KAFKAGROUPID=consu-original-trans --name fnb-stream keletsoox/fnb-kafka-stream
```

You can change the KAFKAENDPOINT based on where kafka docker its running 
##Please note i was not able to do enrishment on the consumed data due to time