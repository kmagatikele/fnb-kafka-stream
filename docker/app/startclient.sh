#!/usr/bin/env sh
#REM ******************************************************************************
#REM ----------------------------------------------------------
#REM *   Console Output for Monitor  						**
#REM **********************************************************
cd /opt/app/

echo "01 Kafka endpoint is : $KAFKAENDPOINT"
echo "02 Kafka Topic is : $KAFKATOPIC"
echo "03 Kafka GroupId is : $KAFKAGROUPID"

java -Xms64m -Xmx2G -jar fnb-kafka-stream.jar $KAFKAENDPOINT $KAFKATOPIC $KAFKAGROUPID


