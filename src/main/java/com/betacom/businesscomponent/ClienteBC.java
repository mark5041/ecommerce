package com.betacom.businesscomponent;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.betacom.architecture.dao.ClienteDAO;
import com.betacom.businesscomponent.model.Cliente;
import com.betacom.architecture.dbaccess.DBAccess;

public class ClienteBC {
	private ClienteDAO cDAO;

	public ClienteBC() throws NamingException, SQLException {
		cDAO = ClienteDAO.getFactory();
	}

	public ArrayList<Cliente> getClienti() throws SQLException, NamingException {
		try {
			return cDAO.getClienti(DBAccess.getConnection());
		} finally {
			DBAccess.closeConnection();
		}
	}

	public void create(Cliente c) throws SQLException, NamingException {
		try {
			cDAO.create(DBAccess.getConnection(), c);
		} finally {
			DBAccess.closeConnection();
		}
	}

	public void update(Cliente c) throws SQLException, NamingException {
		try {
			cDAO.update(DBAccess.getConnection(), c);
		} finally {
			DBAccess.closeConnection();
		}
	}

	public void delete(long id) throws SQLException, NamingException {
		try {
			cDAO.delete(DBAccess.getConnection(), id);
		} finally {
			DBAccess.closeConnection();
		}
	}

	public Cliente findByUsername(String username) throws SQLException, NamingException {
		try {
			return cDAO.findByUsername(DBAccess.getConnection(), username);
		} finally {
			DBAccess.closeConnection();
		}
	}
}
