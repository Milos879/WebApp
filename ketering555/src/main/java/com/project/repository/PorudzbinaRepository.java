package com.project.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.Statement;
import com.project.model.Porudzbina;

public class PorudzbinaRepository {
	private Connection connection;
	private String query;
	private PreparedStatement statment;
	private ResultSet resultSet;
    
	
	
public PorudzbinaRepository(Connection conn){
	
	this.connection=conn;
	
}

public void createPorduzbina(Porudzbina por) throws SQLException{

	query="insert into porudzbina(korisnik_id,ponuda_id,kolicina,cena,date,address) values(?,?,?,?,?,?)";
	statment=connection.prepareStatement(query);
    statment.setInt(1, por.getUser_id());
    statment.setInt(2, por.getPonuda_id());
    statment.setInt(3, por.getKolicina());
    statment.setDouble(4,por.getPrice());
    statment.setString(5,por.getDatum());
    statment.setString(6,por.getAddress());
	
    statment.executeUpdate();
    
}

public ArrayList<Porudzbina> getAllPorudzbine() throws SQLException{
	
	ArrayList<Porudzbina> por= new ArrayList<Porudzbina>();
	
	
	query="select p.id,p.date,p.cena,p.kolicina,p.address ,po.name,u.name from porudzbina as p inner join korisnik as u on p.korisnik_id=u.id inner join ponude as po on po.id=p.ponuda_id";
	statment=connection.prepareStatement(query);
  
	
	
	resultSet= statment.executeQuery();

	while(resultSet.next()){
		
		Porudzbina p= new Porudzbina();
		p.setId(resultSet.getInt("p.id"));
		p.setDatum(resultSet.getString("p.date"));
		p.setPrice(resultSet.getDouble("p.cena"));
		p.setKolicina(resultSet.getInt("p.kolicina"));
		p.setAddress(resultSet.getString("p.address"));
		p.setUser(resultSet.getString("u.name"));
		p.setPonuda(resultSet.getString("po.name"));
		
		por.add(p);
	}
	
	
	return por;
	

}
	
	
	
	
} 





