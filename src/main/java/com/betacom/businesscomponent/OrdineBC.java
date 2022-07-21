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
	
	public void create(Ordine ordine) throws SQLException, NamingException {
		try {
			OrdineDAO.getFactory().create(DBAccess.getConnection(), ordine);
		} finally {
			DBAccess.closeConnection();
		}
	}
	
	public Ordine[] getOrdini() throws SQLException, NamingException {
		Ordine[] ordini = null;
		try {
			ordini = OrdineDAO.getFactory().getAll(DBAccess.getConnection());
		} finally {
			DBAccess.closeConnection();
		}
		return ordini;
	}
	
	public void delete(long id) throws NamingException, SQLException {
		try {
			OrdineDAO.getFactory().delete(DBAccess.getConnection(), id);
		}  finally {
			DBAccess.closeConnection();
		}
	}
}