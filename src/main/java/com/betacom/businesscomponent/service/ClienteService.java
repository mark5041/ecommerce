package com.betacom.businesscomponent.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.naming.NamingException;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.betacom.businesscomponent.ClienteBC;
import com.betacom.businesscomponent.model.Cliente;

@Path("/clienteservice")
public class ClienteService {
	
		
	@GET
	@Path("/clienti")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Cliente> getClienti() throws NamingException, SQLException {
		ClienteBC cBC = new ClienteBC();
		return cBC.getClienti();
	}
	
	@GET
	@Path("/cliente/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public Cliente getCliente(@PathParam("username") String username) throws NamingException, SQLException {
		ClienteBC cBC = new ClienteBC();
		return cBC.clienteByUsername(username);
	}
	
	@POST
	@Path("/createcliente")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public Cliente createCliente(Cliente cliente) 
			throws NamingException, SQLException, ParseException {
		ClienteBC cBC = new ClienteBC();
		cBC.createCliente(cliente);
		return cliente;
	}
	
	@PUT
	@Path("/updatecliente")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public Cliente updateProdotto(Cliente cliente) 
			throws NamingException, SQLException, ParseException {
		ClienteBC cBC = new ClienteBC();
		cBC.updateCliente(cliente);
		return cliente;
	}
	
	@DELETE
	@Path("/deletecliente/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public void deleteCliente(@PathParam("id") long id) 
			throws NamingException, SQLException {
		ClienteBC cBC = new ClienteBC();
		cBC.deleteCliente(id);
	}
}
