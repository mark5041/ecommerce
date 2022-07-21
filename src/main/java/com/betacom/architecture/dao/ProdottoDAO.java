package com.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.betacom.businesscomponent.model.Prodotto;

public class ProdottoDAO implements DAOConstants {
	private Statement stmt;
	private ResultSet rs;
	
	public static ProdottoDAO getFactory() {
		return new ProdottoDAO();
	}
	
	private ProdottoDAO() {
	}
	
	public ArrayList<Prodotto> getProdotti(Connection conn) throws SQLException  {
		stmt = conn.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		rs = stmt.executeQuery(SELECT_PRODOTTO);
		
		ArrayList<Prodotto> lista = new ArrayList<Prodotto>();
		rs.beforeFirst();
		while(rs.next()) {
			Prodotto p = new Prodotto();
			p.setId(rs.getLong(1));
			p.setMarca(rs.getString(2));
			p.setModello(rs.getString(3));
			p.setPrezzo(rs.getDouble(4));
			
			lista.add(p);
		}
		return lista;
	}
	
	public void createProdotto(Connection conn, Prodotto p) throws SQLException {
		PreparedStatement pr = conn.prepareStatement(INSERT_PRODOTTO);
		if(p != null) {
			pr.setString(1, p.getMarca());
			pr.setString(2, p.getModello());
			pr.setDouble(3, p.getPrezzo());
			pr.setString(4, p.getImg());
			
			pr.execute();
		}
	}
	
	public Prodotto findByMarca(Connection conn, String marca) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(SELECT_BYMARCA);
		ps.setString(1, marca);
		Prodotto p = new Prodotto();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			p.setId(rs.getLong(1));
			p.setMarca(rs.getString(2));
			p.setModello(rs.getString(3));
			p.setPrezzo(rs.getDouble(4));
		}
		return p;
	}
	
	public Prodotto findByModello(Connection conn, String modello) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(SELECT_BYMODELLO);
		ps.setString(1, modello);
		Prodotto p = new Prodotto();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			p.setId(rs.getLong(1));
			p.setMarca(rs.getString(2));
			p.setModello(rs.getString(3));
			p.setPrezzo(rs.getDouble(4));
		}
		return p;
	}
	
	public void deleteProdotto(Connection conn, long id) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(DELETE_PRODOTTO);
		ps.setLong(1, id);
		ps.execute();
	}
	
	public void updateProdotto(Connection conn, Prodotto p) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(UPDATE_PRODOTTO);
		ps.setString(1, p.getMarca());
		ps.setString(2, p.getModello());
		ps.setDouble(3, p.getPrezzo());
		ps.setString(4, p.getImg());
		ps.setLong(5, p.getId());
		ps.execute();
	}
}
