package com.betacom.architecture.dao;

public interface DAOConstants {
	//####################CLIENTE####################
	String SELECT_CLIENTE = "Select id, nome, cognome, "
			+ "username, password, email from cliente order by id";
	String SELECT_BYUSERNAME ="Select * from cliente where username = ?";
	String UPDATE_CLIENTE = "Update cliente set nome = ?, cognome = ?, "
			+ "password = ?, email = ? where id = ?";
	String DELETE_CLIENTE = "Delete from cliente where id = ?";
	String INSERT_CLIENTE = "insert into cliente (nome, cognome, username, email, password) values (?, ?, ?, ?, ?)";
	
	//####################PRODOTTO####################
	String SELECT_PRODOTTO = "Select id, marca, modello, prezzo from prodotto order by marca";
	String SELECT_BYMARCA ="Select * from prodotto where marca = ?";
	String SELECT_BYMODELLO ="Select * from prodotto where modello = ?";
	String UPDATE_PRODOTTO = "Update prodotto set marca = ?, modello = ?, prezzo = ? where id = ?";
	String DELETE_PRODOTTO = "Delete from prodotto where id = ?";
	String INSERT_PRODOTTO = "insert into prodotto (marca, modello, prezzo) values (?, ?, ?)";
	
	//####################ORDINE####################
	String SELECT_ORDINE = "Select * from ordine";
    String INSERT_ORDINE = "insert into ordine (data, indirizzo, totale, id_cliente) values (?, ?, ?, ?)";
    String UPDATE_ORDINE = "Update ordine set data = ?, indirizzo = ?, totale = ?, id_cliente = ? where id_ordine = ?";
    String DELETE_ORDINE = "Delete from ordine where id_ordine = ?";
    
}
