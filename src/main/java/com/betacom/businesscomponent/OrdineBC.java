package com.betacom.businesscomponent;

import java.sql.SQLException;

import javax.naming.NamingException;

import com.betacom.architecture.dao.OrdineDAO;
import com.betacom.architecture.dbaccess.DBAccess;
import com.betacom.businesscomponent.model.Ordine;

public class OrdineBC {
	public OrdineDAO oDAO;
	
	public OrdineBC() throws SQLException, NamingException {
		oDAO = OrdineDAO.getFactory();
	}
	
	public Ordine createOrdine(long id) throws SQLException, NamingException {
		try {
			return OrdineDAO.getFactory().createOrdine(DBAccess.getConnection(), id);
		} finally {
			DBAccess.closeConnection();
		}
	}
	
	public Ordine[] getOrdini() throws SQLException, NamingException {
		Ordine[] ordini = null;
		try {
			ordini = OrdineDAO.getFactory().getOrdini(DBAccess.getConnection());
		} finally {
			DBAccess.closeConnection();
		}
		return ordini;
	}
	
	public void deleteOrdine(long id) throws NamingException, SQLException {
		try {
			OrdineDAO.getFactory().deleteOrdine(DBAccess.getConnection(), id);
		}  finally {
			DBAccess.closeConnection();
		}
	}
	
	public void confermaOrdine(Ordine ordine) throws NamingException, SQLException {
		try {
			OrdineDAO.getFactory().confermaOrdine(DBAccess.getConnection(), ordine);
		}  finally {
			DBAccess.closeConnection();
		}
	}
}