package com.project.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.model.Cart;
import com.project.model.Ponude;
import com.project.model.Korisnik;

public class PonudeRepository {
	
	private Connection connection;
	private String query;
	private PreparedStatement statment;
	private ResultSet resultSet;

	
	
	
public PonudeRepository(Connection conn){
	
	this.connection=conn;
	
}
	
	
public List<Ponude> getAllActivePonude() throws SQLException{
	
	List<Ponude> products=new ArrayList<Ponude>();
	
	
	query="select * from ponude where active=?";
	statment= connection.prepareStatement(query);
	statment.setInt(1, 1);
	resultSet=statment.executeQuery();
	
	while(resultSet.next()){
		
		Ponude p= new Ponude();
		
		p.setId(resultSet.getInt("id"));
		p.setName(resultSet.getString("name"));
		p.setCategory(resultSet.getString("category"));
		p.setPrice(resultSet.getDouble("price"));
		p.setImage(resultSet.getString("image"));
		p.setActive(resultSet.getInt("active"));
		products.add(p);
		
	}
	
	return products;
}
	




public ArrayList<Ponude> getAllPassivePonude() throws SQLException{
	
	ArrayList<Ponude> products=new ArrayList<Ponude>();
	
	
	query="select * from ponude where active=?";
	statment= connection.prepareStatement(query);
	statment.setInt(1, 0);
	resultSet=statment.executeQuery();
	
	while(resultSet.next()){
		
		Ponude p= new Ponude();
		
		p.setId(resultSet.getInt("id"));
		p.setName(resultSet.getString("name"));
		p.setCategory(resultSet.getString("category"));
		p.setPrice(resultSet.getDouble("price"));
		p.setImage(resultSet.getString("image"));
		p.setActive(resultSet.getInt("active"));
		products.add(p);
		
	}
	
	return products;
}









public ArrayList<Cart> getAllCart(List<Cart>  cartovi) throws SQLException{
	
	ArrayList<Cart> novi= new ArrayList<>();                                                                                    
	
	query="select *  from ponude  where id=?";
    statment=connection.prepareStatement(query);
    
    
    if(cartovi.size()>0){
    	for(Cart t : cartovi){
    		 
    		statment.setInt(1, t.getId());
    		resultSet=statment.executeQuery();
    		
    		while(resultSet.next()){
    			Cart c=new Cart();
    			
    			c.setId(resultSet.getInt("id"));
    			c.setCategory(resultSet.getString("category"));
    			c.setPrice(resultSet.getDouble("price")*t.getQuantity());
    			c.setName(resultSet.getString("name"));
    			c.setQuantity(t.getQuantity());
    			
    		    novi.add(c);
    		}
    		
    		
    	}
    }
   System.out.println(novi.size());
    return novi;
}
	

public static double ukupnaCena(List<Cart> cart){
	
	double cena=0;
	for(Cart c: cart){
		cena+=c.getPrice();
	}
	return cena;
	
}
public static double ukupnaKolicina(List<Cart> cart){
	
	double kolicina=0;
	for(Cart c: cart){
		kolicina+=c.getQuantity();
	}
	return kolicina;
	
}

public void dodajPasivnuPonudu(int id) throws SQLException{
	query = "update ponude set active=? where id=?";
	statment = connection.prepareStatement(query);
	statment.setInt(1, 1);
	statment.setInt(2,id);
	statment.executeUpdate();
	
}


public void obrisiAktivnuPonudu(int id) throws SQLException{
	query = "update ponude set active=? where id=?";
	statment = connection.prepareStatement(query);
	statment.setInt(1, 0);
	statment.setInt(2,id);
	statment.executeUpdate();
	
}


}
