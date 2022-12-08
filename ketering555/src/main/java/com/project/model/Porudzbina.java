package com.project.model;

import java.io.Serializable;

public class Porudzbina implements Serializable {


	private static final long serialVersionUID = -2105605274837099567L;
	
	
private int id;
private int user_id;
private int ponuda_id;
private String address;
private String datum;
private double price;
private int kolicina;


private String user;
private String ponuda;


public Porudzbina(){
	
}


public Porudzbina(int id, int user_id, int ponuda_id, String address, String datum, double price, int kolicina) {
	super();
	this.id = id;
	this.user_id = user_id;
	this.ponuda_id = ponuda_id;
	this.address = address;
	this.datum = datum;
	this.price = price;
	this.kolicina = kolicina;
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public int getUser_id() {
	return user_id;
}


public void setUser_id(int user_id) {
	this.user_id = user_id;
}


public int getPonuda_id() {
	return ponuda_id;
}


public void setPonuda_id(int ponuda_id) {
	this.ponuda_id = ponuda_id;
}


public String getAddress() {
	return address;
}


public void setAddress(String address) {
	this.address = address;
}


public String getDatum() {
	return datum;
}


public void setDatum(String datum) {
	this.datum = datum;
}


public double getPrice() {
	return price;
}


public void setPrice(double price) {
	this.price = price;
}


public int getKolicina() {
	return kolicina;
}


public void setKolicina(int kolicina) {
	this.kolicina = kolicina;
}


public String getUser() {
	return user;
}


public void setUser(String user) {
	this.user = user;
}


public String getPonuda() {
	return ponuda;
}


public void setPonuda(String ponuda) {
	this.ponuda = ponuda;
}



}
