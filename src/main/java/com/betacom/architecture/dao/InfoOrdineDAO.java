package com.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.betacom.businesscomponent.model.InfoOrdine;


public class InfoOrdineDAO implements DAOConstants {
	private CachedRowSet rowSet;

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

    public void create(Connection conn, InfoOrdine[] entity)  {

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
    
    public void update(Connection conn, ArrayList<InfoOrdine> entity) {

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

    
    public void delete(Connection conn, ArrayList<InfoOrdine> entity) {

        try {
        	
            for(InfoOrdine inf: entity) {
            	PreparedStatement ps;
            	ps = conn.prepareStatement(UPDATE_INFO_ORDINE);
                ps.setInt(1, inf.getQuantita());
                ps.setLong(1, inf.getId_ordine());
                ps.setLong(2, inf.getId_prodotto());
                ps.execute();

                conn.commit();
            }
            
        } catch (SQLException exc) {
            System.out.println("Errore: " + exc.getMessage());
        }
    }
    
    
    
    
}
