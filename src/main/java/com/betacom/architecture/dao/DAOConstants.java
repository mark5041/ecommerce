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
	String UPDATE_PRODOTTO = "Update prodotto set marca = ?, modello = ?, prezzo = ?, img = ? where id = ?";
	String DELETE_PRODOTTO = "Delete from prodotto where id = ?";
	String INSERT_PRODOTTO = "insert into prodotto (marca, modello, prezzo, img) values (?, ?, ?, ?)";
	
	//####################ORDINE####################
	String SELECT_ORDINE = "Select * from ordine";
    String INSERT_ORDINE = "insert into ordine (data, indirizzo, totale, id_cliente) values (?, ?, ?, ?)";
    String UPDATE_ORDINE = "Update ordine set data = ?, indirizzo = ?, totale = ?, id_cliente = ? where id_ordine = ?";
    String DELETE_ORDINE = "Delete from ordine where id_ordine = ?";
    String CONFERMA_ORDINE = "Update ordine set status = 'confermato' where id_ordine = ?";
    
    //####################ORDINE####################
    String SELECT_INFO_CART = "Select p.marca, p.modello, p.prezzo, inf.quantita from info_ordine inf right join prodotto p on(inf.id_prodotto = p.id) right join ordine o on(inf.id_ordine = o.id) where o.id_cliente = ? and o.status = 'non confermato'"; 
    String SELECT_INFO_ORDER = "Select o.id, p.marca, p.modello, p.prezzo, inf.quantita from info_ordine inf right join prodotto p on (inf.id_prodotto = p.id) right join ordine o on(inf.id_ordine = o.id) where o.id_cliente = ? and o.status != 'non confermato'";
    String INSERT_INFO_ORDINE = "Insert into info_ordine(id_ordine, id_prodotto, quantita) values (?,?,?)";
    String DELETE_INFO_ORDINE = "Delete from info_ordine where id_ordine = ? and id_prodotto = ?";
    String UPDATE_INFO_ORDINE = "Update info_ordine set quantita = ? where id_ordine = ? and id_prodotto = ?";
    
}

