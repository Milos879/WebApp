package com.project.repository;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.Statement;
import com.project.config.DBConnection;
import com.project.model.Korisnik;

public class KorisnikRepository {

	private Connection connection;
	private String query;
	private PreparedStatement statment;
	private ResultSet resultSet;

	public KorisnikRepository(Connection conn) {
		this.connection = conn;
	}

	public boolean createUser(Korisnik user) {
      
		query = "insert into korisnik (name,password,email,role,surname,address)  values(?,?,?,?,?,?)";
		try {
			statment = connection.prepareStatement(query);
			statment.setString(1, user.getName());
			statment.setString(2, user.getPassword());
			statment.setString(3, user.getEmail());
			statment.setString(4, user.getRole());
			statment.setString(5, user.getSurname());
			statment.setString(6, user.getAddress());
			statment.executeUpdate();
			
			 			return true;

		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}

	}

	public void updateUser(int id, String name, String surname, String address) throws SQLException {
		query = "update korisnik set name=?,surname=?,address=? where id=?";
		statment = connection.prepareStatement(query);
		statment.setString(1, name);
		statment.setString(2, surname);
		statment.setString(3, address);
		statment.setInt(4, id);

		statment.executeUpdate();
	}
	
	
	

	public Korisnik getUser(String email, String password) throws SQLException {
		Korisnik user = null;

		query = "select * from korisnik where email=? and password=?";

		statment = connection.prepareStatement(query);
		statment.setString(1, email);
		statment.setString(2, password);

		resultSet = statment.executeQuery();

		while (resultSet.next()) {

			user = new Korisnik();
			user.setId(resultSet.getInt("id"));
			user.setEmail(resultSet.getString("email"));
			user.setName(resultSet.getString("name"));
			user.setPassword(resultSet.getString("password"));
			user.setDiscount(resultSet.getInt("discount"));
			user.setSurname(resultSet.getString("surname"));
			user.setRole(resultSet.getString("role"));
			user.setAddress(resultSet.getString("address"));
		}
		return user;
	}

	public boolean emailExists(String email) throws SQLException {

		int result = 0;

		query = "select COUNT(*) from korisnik where email=?";
		statment = connection.prepareStatement(query);
		statment.setString(1, email);
		resultSet = statment.executeQuery();

		while (resultSet.next()) {
			result = resultSet.getInt("COUNT(*)");

		}

		if (result > 0) {
			return true;
		} else
			return false;
	}



public void deleteUser(int id) throws SQLException {
	
	query="delete from korisnik where id=?";
	statment=connection.prepareStatement(query);
	
	statment.setInt(1, id);
	statment.executeUpdate();
	
	
	
}

public void deleteDiscount(int id) throws SQLException{
	query = "update korisnik set discount=? where id=?";
	statment = connection.prepareStatement(query);
	statment.setInt(1,0);
	statment.setInt(2,id);
	statment.executeUpdate();
	
	System.out.println("Popust REGISTRACIJA");
}


public ArrayList<Korisnik> getAllKorisnik() throws SQLException{
	ArrayList<Korisnik> kor = new ArrayList<Korisnik>();
	
	query = "select * from korisnik";
	statment = connection.prepareStatement(query);
    resultSet =statment.executeQuery();
    
	while (resultSet.next()) {

		Korisnik user = new Korisnik();
		user.setId(resultSet.getInt("id"));
		user.setEmail(resultSet.getString("email"));
		user.setName(resultSet.getString("name"));
		user.setPassword(resultSet.getString("password"));
		user.setDiscount(resultSet.getInt("discount"));
		user.setSurname(resultSet.getString("surname"));
		user.setRole(resultSet.getString("role"));
		user.setAddress(resultSet.getString("address"));
	   kor.add(user);
	}
    return kor;
}


}
