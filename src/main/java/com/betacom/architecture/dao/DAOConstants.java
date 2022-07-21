package com.betacom.architecture.dao;

public interface DAOConstants {
	String SELECT_CLIENTE = "Select id, nome, cognome, "
			+ "username, password, email from cliente order by id";
	String SELECT_BYUSERNAME ="Select * from cliente where username = ?";
	String UPDATE_CLIENTE = "Update cliente set nome = ?, cognome = ?, "
			+ "password = ?, email = ? where id = ?";
	String DELETE_CLIENTE = "Delete from cliente where id = ?";
	String INSERT_CLIENTE = "insert into cliente (nome, cognome, username, email, password) values (?, ?, ?, ?, ?)";
}
