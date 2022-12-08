package com.project.model;

public class Cart extends Ponude{

private int  quantity=1;


public Cart() {}



public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}



@Override
public String toString() {
	return "Cart [quantity=" + quantity + "]"+super.toString();
}

	



	
}
