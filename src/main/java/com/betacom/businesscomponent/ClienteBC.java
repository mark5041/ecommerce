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

	public void createCliente(Cliente c) throws SQLException, NamingException {
		try {
			cDAO.createCliente(DBAccess.getConnection(), c);
		} finally {
			DBAccess.closeConnection();
		}
	}

	public void updateCliente(Cliente c) throws SQLException, NamingException {
		try {
			cDAO.updateCliente(DBAccess.getConnection(), c);
		} finally {
			DBAccess.closeConnection();
		}
	}

	public void deleteCliente(long id) throws SQLException, NamingException {
		try {
			cDAO.deleteCliente(DBAccess.getConnection(), id);
		} finally {
			DBAccess.closeConnection();
		}
	}

	public Cliente clienteByUsername(String username) throws SQLException, NamingException {
		try {
			return cDAO.clienteByUsername(DBAccess.getConnection(), username);
		} finally {
			DBAccess.closeConnection();
		}
	}
}
