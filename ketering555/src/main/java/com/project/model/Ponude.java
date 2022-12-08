package com.project.model;

import java.io.Serializable;

public class Ponude implements Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int id;
private String name;
private double price;
private String category;
private String image;
private int active;


public Ponude() {
	
	
}






public Ponude(int id, String name, double price, String category, String image,int active) {
	super();
	this.id = id;
	this.name = name;
	this.price = price;
	this.category = category;
	this.image = image;
	this.active=active;
}





public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
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
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}






public int getActive() {
	return active;
}






public void setActive(int active) {
	this.active = active;
}












	
	
}
