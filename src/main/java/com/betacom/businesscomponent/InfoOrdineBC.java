package com.betacom.businesscomponent;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.betacom.architecture.dao.InfoOrdineDAO;
import com.betacom.architecture.dbaccess.DBAccess;
import com.betacom.businesscomponent.model.InfoOrdine;
import com.betacom.businesscomponent.model.OrderConfirmed;

public class InfoOrdineBC {
	private InfoOrdineDAO inf;

	public InfoOrdineBC() throws NamingException, SQLException {
		inf = InfoOrdineDAO.getFactory();
	}

	public OrderConfirmed[] getOrderConfirmed(long id) throws SQLException, NamingException {
		try {
			return inf.getOrderConfirm(DBAccess.getConnection(), id);
		} finally {
			DBAccess.closeConnection();
		}
	}
	
	public OrderConfirmed[] getCart(long id) throws SQLException, NamingException {
		try {
			return inf.getCart(DBAccess.getConnection(), id);
		} finally {
			DBAccess.closeConnection();
		}
	}

	public void createInfoOrdine(ArrayList<InfoOrdine> io) throws SQLException, NamingException {
		try {
			inf.createInfoOrdine(DBAccess.getConnection(), io);
		} finally {
			DBAccess.closeConnection();
		}
	}

	public void updateInfoOrdine(ArrayList<InfoOrdine> io) throws SQLException, NamingException {
		try {
			inf.createInfoOrdine(DBAccess.getConnection(), io);
		} finally {
			DBAccess.closeConnection();
		}
	}

	public void deleteInfoOrdine(ArrayList<InfoOrdine> io) throws SQLException, NamingException {
		try {
			inf.deleteInfoOrdine(DBAccess.getConnection(), io);
		} finally {
			DBAccess.closeConnection();
		}
	}
	
}
