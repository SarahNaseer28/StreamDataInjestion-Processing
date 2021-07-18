package com.order.data;

import com.google.gson.Gson;
import java.time.LocalDate;

public class OrderInfo 
{
	
	private String orderId;
	private LocalDate date;
	private double amount;
	private Product product;
	
	//Order(orderId, date, amount, products:[product_info{product_code, name, price, qty}])

	public OrderInfo(){
	}
	
	public OrderInfo(String orderId,LocalDate date,double amount,Product product)
	{
		this.orderId=orderId;
		this.date=date;
		this.amount=amount;
		this.product=product;
	}
	
	
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String toString()
	{
		Gson gson = new Gson();
		return gson.toJson(this);
	}
}


class Product
{
	private Integer productCode;
	private String name;
	private double price;
	private int quantity;
	
	
	public Product(Integer productCode,String name,double price,int quantity)
	{
		this.name=name;
		this.price=price;
		this.productCode=productCode;
		this.quantity=quantity;
	}
	
	
	
	public Integer getProductCode() {
		return productCode;
	}


	public void setProductCode(Integer productCode) {
		this.productCode = productCode;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String toString()		//wont work in windows for now
	{
		Gson gson = new Gson();
		return gson.toJson(this);
	}
	
	
	
	
}
