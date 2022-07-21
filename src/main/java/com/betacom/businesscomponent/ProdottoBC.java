package com.betacom.businesscomponent;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.betacom.architecture.dao.ProdottoDAO;
import com.betacom.architecture.dbaccess.DBAccess;
import com.betacom.businesscomponent.model.Prodotto;

public class ProdottoBC {
	
	private ProdottoDAO pDAO;
	
	public ProdottoBC() throws NamingException, SQLException {
		pDAO = ProdottoDAO.getFactory();
	}

	public ArrayList<Prodotto> getProdotti() throws SQLException, NamingException {
		try {
			return pDAO.getProdotti(DBAccess.getConnection());
		} finally {
			DBAccess.closeConnection();
		}
	}

	public void createProdotto(Prodotto p) throws SQLException, NamingException {
		try {
			pDAO.createProdotto(DBAccess.getConnection(), p);
		} finally {
			DBAccess.closeConnection();
		}
	}

	public void updateProdotto(Prodotto p) throws SQLException, NamingException {
		try {
			pDAO.updateProdotto(DBAccess.getConnection(), p);
		} finally {
			DBAccess.closeConnection();
		}
	}

	public void deleteProdotto(long id) throws SQLException, NamingException {
		try {
			pDAO.deleteProdotto(DBAccess.getConnection(), id);
		} finally {
			DBAccess.closeConnection();
		}
	}

	public Prodotto findByMarca(String marca) throws SQLException, NamingException {
		try {
			return pDAO.findByMarca(DBAccess.getConnection(), marca);
		} finally {
			DBAccess.closeConnection();
		}
	}
	
	public Prodotto findByModello(String modello) throws SQLException, NamingException {
		try {
			return pDAO.findByMarca(DBAccess.getConnection(), modello);
		} finally {
			DBAccess.closeConnection();
		}
	}
}
