package com.order.data;

import static com.order.data.GenerateOrderInfo.generateRandomOrderId;
import static com.order.data.GenerateOrderInfo.generateRandomDate;
import static com.order.data.GenerateOrderInfo.generateRandomAmount;
import static com.order.data.GenerateOrderInfo.generateProductCode;
import static com.order.data.GenerateOrderInfo.generateProductinfo;
import static com.order.data.GenerateOrderInfo.generateRandomPrice;
import static com.order.data.GenerateOrderInfo.generateRandomQty;

import java.util.Random;

public class SendDataToKafka {

	public static void main(String[] args) throws InterruptedException {
		while (true) {
			int records = new Random().nextInt(5);//in-memory mutable 4Bytes
			///RDD rdd1 = rdd.load("truck_info.json")// 2551818(2.5) < 128 MB(block size) 16 blocks (4 nodes 4 block each)
			for (int i = 1; i <= records; i++) {
				OrderInfo orderinfo = new OrderInfo();
				orderinfo.setOrderId(generateRandomOrderId());
				orderinfo.setDate(generateRandomDate(2010,2021));
				orderinfo.setAmount(generateRandomAmount(3000.0,20000.0));
				Integer Pcode=generateProductCode();
				orderinfo.setProduct(new Product(Pcode,generateProductinfo(Pcode),generateRandomPrice(1900.0,10000.0),generateRandomQty(4)));
				
				//SimpleKafkaProducer.sendDataToKafkaSingleBroker(orderinfo.toString(),"order-info");
				SimpleKafkaProducer.sendDataToKafkaMultipleBroker(orderinfo.toString(), "order-info-new",orderinfo.getProduct().getName());
			}
			System.out.println("Written " + records + " records to Kafka..");
			Thread.sleep(4000);	}
	}
}
//ZOOKEEPER - ./bin/zookeeper-server-start.sh config/zookeeper.properties
//SERVER/BROKER - ./bin/kafka-server-start.sh config/server.properties
//CONSUMER - ./bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic order-info --from-beginning

