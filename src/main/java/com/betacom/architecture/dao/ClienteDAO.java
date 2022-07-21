package com.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.betacom.businesscomponent.model.Cliente;

public class ClienteDAO implements DAOConstants {
	private Statement stmt;
	private ResultSet rs;
	
	public static ClienteDAO getFactory() {
		return new ClienteDAO();
	}
	
	private ClienteDAO() {
	}
	
	public ArrayList<Cliente> getClienti(Connection conn) throws SQLException  {
		stmt = conn.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		rs = stmt.executeQuery(SELECT_CLIENTE);
		
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		rs.beforeFirst();
		while(rs.next()) {
			Cliente c = new Cliente();
			c.setId(rs.getLong(1));
			c.setNome(rs.getString(2));
			c.setCognome(rs.getString(3));
			c.setUsername(rs.getString(4));
			c.setPassword(rs.getString(5));
			c.setEmail(rs.getString(6)); 
			lista.add(c);
		}
		return lista;
	}
	
	public void createCliente(Connection conn, Cliente c) throws SQLException {
		PreparedStatement pr = conn.prepareStatement(INSERT_CLIENTE);
		if(c != null) {
			pr.setString(1, c.getNome());
			pr.setString(2, c.getCognome());
			pr.setString(3, c.getUsername());
			pr.setString(4, c.getEmail());
			pr.setString(5, c.getPassword());
			pr.execute();
		}
	}
	
	public Cliente clienteByUsername(Connection conn, String username) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(SELECT_BYUSERNAME);
		ps.setString(1, username);
		Cliente c = new Cliente();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			c.setId(rs.getLong(1));
			c.setNome(rs.getString(2));
			c.setCognome(rs.getString(3));
			c.setUsername(rs.getString(4));
			c.setPassword(rs.getString(5));
			c.setEmail(rs.getString(6)); 
		}
		return c;
	}
	
	public void deleteCliente(Connection conn, long id) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(DELETE_CLIENTE);
		ps.setLong(1, id);
		ps.execute();
	}
	
	public void updateCliente(Connection conn, Cliente c) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(UPDATE_CLIENTE);
		ps.setString(1, c.getNome());
		ps.setString(2, c.getCognome());
		ps.setString(3, c.getPassword());
		ps.setString(4, c.getEmail());
		ps.setLong(5, c.getId());
		ps.execute();
	}
}
