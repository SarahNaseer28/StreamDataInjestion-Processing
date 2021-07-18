package com.order;

import java.util.Arrays;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class JavaSparkExample {

	public static void main(String[] args) {
		SparkConf conf=new SparkConf().setAppName("SparkExample").setMaster("local[*]");
		JavaSparkContext sc=new JavaSparkContext(conf);
		
		List<Integer> list=Arrays.asList(33,6,14,8,27,10,76,2);
		
		JavaRDD<Integer> listRDD=sc.parallelize(list,2);
		
		System.out.println("Count : "+listRDD.count());
		
		JavaRDD<Integer> filteredRDD = listRDD.filter(rdd -> rdd % 2 == 0);
		
		System.out.println("Filtered Count : "+filteredRDD.count());
		
		sc.close();

	}

}
