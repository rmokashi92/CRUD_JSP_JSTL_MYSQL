package com.demo;

import java.io.Serializable;

public class Books implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int book_id;
	private double price;
	private String author;
	private String title;
	
	public Books(int book_id,String title,String author,double price)
	{
		this.book_id = book_id;
		this.author = author;
		this.price = price;
		this.title = title;
	}
	
	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	
}



