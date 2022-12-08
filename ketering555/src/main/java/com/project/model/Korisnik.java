package com.project.model;

import java.io.Serializable;

public class Korisnik  implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
private int id;
private String name;
private String surname;
private String password;
private String email;
private String role;
private int discount;
private String address;
public Korisnik() {
	
}





public Korisnik(String name, String surname, String password, String email, String role,String address) {
	super();
	this.name = name;
	this.surname = surname;
	this.password = password;
	this.email = email;
	this.role = role;
    this.address=address;
}





public String getAddress() {
	return address;
}





public void setAddress(String address) {
	this.address = address;
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

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

public int getDiscount() {
	return discount;
}

public void setDiscount(int discount) {
	this.discount = discount;
}





public String getSurname() {
	return surname;
}





public void setSurname(String surname) {
	this.surname = surname;
}





}
