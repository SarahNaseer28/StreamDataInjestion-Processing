package com.order.data;

import static com.order.data.GenerateOrderInfo.generateRandomOrderId;
import static com.order.data.GenerateOrderInfo.generateRandomDate;
import static com.order.data.GenerateOrderInfo.generateRandomAmount;
import static com.order.data.GenerateOrderInfo.generateProductCode;
import static com.order.data.GenerateOrderInfo.generateProductinfo;
import static com.order.data.GenerateOrderInfo.generateRandomPrice;
import static com.order.data.GenerateOrderInfo.generateRandomQty;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class GenerateRandomOrderinfoJson {

	public static void main(String[] args)throws InterruptedException, IOException  {
		
		while (true) {
			
			File file = new File("/home/sarah/eclipse-workspace1/GenerateStreamData/simulated-data/order.json");
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			int records = new Random().nextInt(15);
			for (int i = 1; i <= records; i++) {
				OrderInfo orderinfo = new OrderInfo();
				orderinfo.setOrderId(generateRandomOrderId());
				orderinfo.setDate(generateRandomDate(2010,2021));
				orderinfo.setAmount(generateRandomAmount(3000.0,20000.0));
				Integer Pcode=generateProductCode();
				orderinfo.setProduct(new Product(Pcode,generateProductinfo(Pcode),generateRandomPrice(1900.0,10000.0),generateRandomQty(4)));
				
				// Write the Info data into a file
				bw.append(orderinfo.toString()+"\n");
			}
			System.out.println("Written "+records+"to the file.");
			bw.flush();
			bw.close();
			Thread.sleep(300);
		}

	}

}
