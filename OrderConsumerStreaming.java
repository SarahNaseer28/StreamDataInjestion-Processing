package com.order;

import java.util.*;
import org.apache.spark.SparkConf;


import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.api.java.JavaInputDStream;
import org.apache.spark.streaming.kafka010.*;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import scala.Tuple2;


public class OrderConsumerStreaming {

	public static void main(String[] args) throws InterruptedException{


	SparkConf conf=new SparkConf().setAppName("OrderInfo-Streaming").setMaster("local[*]");
	JavaStreamingContext jssc=new JavaStreamingContext(conf,Durations.seconds(5));
	
	Map<String, Object> kafkaParams = new HashMap<>();
	kafkaParams.put("bootstrap.servers", "localhost:9092,anotherhost:9092");
	kafkaParams.put("key.deserializer", StringDeserializer.class);
	kafkaParams.put("value.deserializer", StringDeserializer.class);
	kafkaParams.put("group.id", "order-info-consumer-grp");
	kafkaParams.put("auto.offset.reset", "latest");
	kafkaParams.put("enable.auto.commit", false);
	
	Collection<String> topics = Arrays.asList("order-info-new");
	
	JavaInputDStream<ConsumerRecord<String, String>> stream =KafkaUtils.createDirectStream(jssc,LocationStrategies.PreferConsistent(),ConsumerStrategies.<String, String>Subscribe(topics, kafkaParams));

	JavaPairDStream<String,String> records=stream.mapToPair(record -> new Tuple2<>(record.key(),record.value()));
	
	//stream.mapToPair(record -> new Tuple2<>(record.key(), record.value()));
	
	records.print();
	
	jssc.start();
	jssc.awaitTermination();
	jssc.close();



	}

}
