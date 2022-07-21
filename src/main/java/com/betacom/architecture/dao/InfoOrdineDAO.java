package com.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.betacom.businesscomponent.model.InfoOrdine;
import com.betacom.businesscomponent.model.OrderConfirmed;


public class InfoOrdineDAO implements DAOConstants {
	private CachedRowSet rowSet;
	private ResultSet rs;

    private InfoOrdineDAO() {
        try {
            rowSet = RowSetProvider.newFactory().createCachedRowSet();
        } catch (Exception exc) {
            System.out.println("Errore: " + exc.getMessage());
        }
    }

    public static InfoOrdineDAO getFactory() {
        return new InfoOrdineDAO();
    }

    public void createInfoOrdine(Connection conn, ArrayList<InfoOrdine> entity)  {

        try {
        	
            for(InfoOrdine inf: entity) {
            	rowSet.setCommand(INSERT_INFO_ORDINE);
                rowSet.execute(conn);

                rowSet.moveToInsertRow();
                rowSet.updateLong(1, inf.getId_ordine());
                rowSet.updateLong(2, inf.getId_prodotto());
                rowSet.updateInt(3, inf.getQuantita());

                rowSet.insertRow();
                rowSet.moveToCurrentRow();
                rowSet.acceptChanges();
            }

        } catch (SQLException exc) {
            System.out.println("Errore: " + exc.getMessage());
        }
    }
    
    public void updateInfoOrdine(Connection conn, ArrayList<InfoOrdine> entity) {

        PreparedStatement ps;

        try {
        	
        	for(InfoOrdine inf: entity) {
        		ps = conn.prepareStatement(UPDATE_INFO_ORDINE);
                ps.setInt(1, inf.getQuantita());
                ps.setLong(2, inf.getId_ordine());
                ps.setLong(3, inf.getId_prodotto());
                
                ps.execute();
                conn.commit();
        	}
            
        } catch (SQLException exc) {
            System.out.println("Errore: " + exc.getMessage());
        }
    }

    
    public void deleteInfoOrdine(Connection conn, ArrayList<InfoOrdine> entity) {

        try {
        	
            for(InfoOrdine inf: entity) {
            	PreparedStatement ps;
            	ps = conn.prepareStatement(DELETE_INFO_ORDINE);
                ps.setLong(1, inf.getId_ordine());
                ps.setLong(2, inf.getId_prodotto());
                ps.execute();

                conn.commit();
            }
            
        } catch (SQLException exc) {
            System.out.println("Errore: " + exc.getMessage());
        }
    }
    
    public OrderConfirmed[] getOrderConfirm(Connection conn, long id) throws SQLException  {
    	PreparedStatement ps;
		ps = conn.prepareStatement(SELECT_INFO_ORDER);
		ps.setLong(1, id);
		rs = ps.executeQuery();
		
		rs.last();
		OrderConfirmed[] lista = new OrderConfirmed[rs.getRow() - 1];
		rs.beforeFirst();
		int i = 0;
		while(rs.next()) {
			OrderConfirmed oc = new OrderConfirmed();
			oc.setMarca(rs.getString(1));
			oc.setModello(rs.getString(2));
			oc.setPrezzo(rs.getDouble(3));
			oc.setQuantita(rs.getInt(4));
			lista[i] = oc;
			i++;
		}
		
		return lista;
	}
    
    public OrderConfirmed[] getCart(Connection conn, long id) throws SQLException  {
    	PreparedStatement ps;
		ps = conn.prepareStatement(SELECT_INFO_CART);
		ps.setLong(1, id);
		rs = ps.executeQuery();
		
		rs.last();
		OrderConfirmed[] lista = new OrderConfirmed[rs.getRow() - 1];
		rs.beforeFirst();
		int i = 0;
		while(rs.next()) {
			OrderConfirmed oc = new OrderConfirmed();
			oc.setMarca(rs.getString(1));
			oc.setModello(rs.getString(2));
			oc.setPrezzo(rs.getDouble(3));
			oc.setQuantita(rs.getInt(4));
			lista[i] = oc;
			i++;
		}
		
		return lista;
	}
    
}
