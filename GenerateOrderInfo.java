package com.order.data;

//import com.google.gson.Gson;


import java.util.HashMap;
import java.util.Random;
import java.util.UUID;
import java.time.LocalDate;

public class GenerateOrderInfo {

	public static void main(String[] args) 
	{
		for (int i = 1; i <= 7; i++) {

			System.out.println("OrderId:" + generateRandomOrderId());

			LocalDate randomDate = generateRandomDate(2010,2021);
			System.out.println("Date:"+randomDate);
			
			System.out.println("Amount:" + generateRandomAmount(3000.0,20000.0));

			Integer Pcode=generateProductCode();
			System.out.println("Product Code:" + Pcode);
			
			System.out.println("Product Name:" + generateProductinfo(Pcode));
			
			System.out.println("Price:" + generateRandomPrice(1900.0,10000.0));
			
			System.out.println("Quantity:" + generateRandomQty(4));
			
			System.out.println("----------------------------");

		}
		

	}
	
	
	

	public static int createRandomIntBetween(int start, int end) {
    return start + (int) Math.round(Math.random() * (end - start));
	}

	public static LocalDate generateRandomDate(int startYear, int endYear) {
		int day = createRandomIntBetween(1, 28);
		int month = createRandomIntBetween(1, 12);
		int year = createRandomIntBetween(startYear, endYear);
		return LocalDate.of(year, month, day);
	}
	
	public static String generateRandomOrderId()
	{
		
		return UUID.randomUUID().toString();
	}
	
	public static double generateRandomAmount(double rangeMin,double rangeMax)
	{
		Random r = new Random();
		double randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
		return randomValue;
	}
	
	public static String generateProductinfo(Integer k)
	{
		HashMap<Integer, String> hmap = new HashMap<Integer, String>();

	      /*Adding elements to HashMap*/
	      hmap.put(101,"Adapter");
	      hmap.put(102,"Multi meter");
	      hmap.put(103,"keyboard");
	      hmap.put(104,"CPU");
	      hmap.put(105,"HardDisk");
	      hmap.put(106,"CCTV Camera");
	      hmap.put(107,"Ignition Cable");
	      
	      //System.out.println("Product Code:" + k);
	      //System.out.println(generateProductCode(k));
	      //System.out.println(value);
	      return hmap.get(k);
	  }
	
	public static Integer generateProductCode()
	{
		Integer[] pCodeArray = {101,102,103,104,105,106,107};
	    Integer code=pCodeArray[new Random().nextInt(pCodeArray.length)];
	   
		return code;
	}
	
	public static double generateRandomPrice(double min,double max)
	{
		return Math.random() * (max - min) + min;
	}
	
	public static int generateRandomQty(int max)
	{
		int rnd = new Random().nextInt(max - 1) + 1;
		return rnd;
		//return new Random().nextInt(max);
	}
	
}