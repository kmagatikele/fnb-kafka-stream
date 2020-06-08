package com.kafka.fnbstream
import java.util
import java.util.{Collections, Properties}
import com.google.gson.Gson
import org.apache.kafka.clients.consumer.{ConsumerRecord, ConsumerRecords, KafkaConsumer}
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord, RecordMetadata}

import scala.collection.JavaConversions._
object Main {
  def main(args: Array[String]): Unit = {

    // Build Model
    var transaction = buildTransaction()
    val gson = new Gson
    val transactionJson = gson.toJson(transaction)

    // PRODUCER
    val topic:String = args(1)
    val producerProperties = new Properties()
    producerProperties.put("bootstrap.servers", args(0))
    producerProperties.put("client.id", "fnb-stream")
    producerProperties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    producerProperties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    val producer = new KafkaProducer[String, String](producerProperties)


    // CONSUMER
    val consumerProperties = new Properties()
    consumerProperties.put("bootstrap.servers", args(0))
    producerProperties.put("client.id", "fnb-stream")
    consumerProperties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    consumerProperties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    consumerProperties.put("group.id", args(2))
    val consumer = new KafkaConsumer[String, String](consumerProperties)
    consumer.subscribe(Collections.singletonList(topic))


    while(true) {

      // WRITING
      val record = new ProducerRecord[String, String](topic, transaction.transactionTraceIdentifier, transactionJson)

      // fire and forget
      producer.send(record)

      // send returns future
      val f = producer.send(record)

      // send with callback
      producer.send(record, (m:RecordMetadata, e:Exception) => {
        println
        println("producer callback:")
        println("checksum " + m.checksum())
        println("offset " + m.offset())
        println("partition " + m.partition())
        println("serialized key size " + m.serializedKeySize())
        println("serialized value size " + m.serializedValueSize())
        println("timestamp " + m.timestamp())
        println("topic " + m.topic())
        println("exception" + e)
      })

      println("Data sent = " + transactionJson)

      // READING
      val records = consumer.poll(100)
      for(record:ConsumerRecord[String, String] <- records) {
        println
        println("consumer reading")
        println("checksum " + record.checksum)
        println("key " + record.key)
        println("offset " + record.offset)
        println("partition " + record.partition )
        println("serializedKeySize " + record.serializedKeySize )
        println("serializedValueSize " + record.serializedValueSize )
        println("timestamp " + record.timestamp )
        println("timestampType " + record.timestampType )
        println("topic " + record.topic )
        println("value " + record.value )

        var consumTransJson = record.value
        var consumTrans = gson.fromJson(consumTransJson, classOf[Transaction])

      }
    }

    producer.close()
    consumer.close()

  }

//  def enrichTransaction(transaction: Transaction): Transaction ={
//    transaction.
//  }


  def buildTransaction(): Transaction ={
    val transaction = new Transaction(
      transactionTraceIdentifier = "TEST",
      accountNumber = "1234567789",
      transactionTypeIdentifier = "12345",
      numberOfTransactions = 0,
      transactionEffectiveDate = "2020-01-01",
      transactionAmount = 123.00,
      accountHoldingCompanyCode = 15,
      accountCurrencyCode = "ZAR",
      transactionOriginalCurrency = "ZAR",
      transactionTypeCode = "C",
      transactionReversalIndicator = null,
      transactionChannel = "test",
      transactionSourceBranchCode = "123",
      transactionSourceSystem = "test",
      eventDateTime = "2020-05-01 12:00:00.000000000000",
      productCode = "test",
      subProductCode=  "test",
      ledgerBalanceAfterTransaction = 1000.31,
      collectedBalanceAfterTransaction = 1000.31,
      transactionSignage= "1",
      transactionGLCategory = "V",
      transactionTypeIndicator = "6",
      remoteBranchClearingCode = "test-100",
      officerCode = "test",
      transactionDescription = "test",
      transactionSequenceNumberStatement = "Y",
      numberOfForeignDepositedItems = "0",
      cashAmount =  0.00,
      interestCollected = 0.00,
      toAccountNumber = "0",
      fromAccountNumber = "0",
      transactionDescriptionContinued = "100",
      originalTransactionAmount =  100.00,
      exchangeRate = 0.0000000,
      acrruedTransactionFee = 0.00
    )

    return transaction
  }
}
