package com.betacom.businesscomponent.service;

import java.sql.SQLException;
import java.text.ParseException;

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

import com.betacom.businesscomponent.OrdineBC;
import com.betacom.businesscomponent.model.Ordine;

@Path("/ordineservice")
public class OrdineService {

	@GET
	@Path("/ordini")
	@Produces(MediaType.APPLICATION_JSON)
	public Ordine[] getOrdini() throws NamingException, SQLException {
		OrdineBC oBC = new OrdineBC();
		return oBC.getOrdini();
	}
	
	@POST
	@Path("/createordine")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public Ordine createOrdine(long id) 
			throws NamingException, SQLException, ParseException {
		OrdineBC oBC = new OrdineBC();
		
		return oBC.createOrdine(id);
	}
	
	@DELETE
	@Path("/deleteordine/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public void deleteOrdine(@PathParam("id") long id) 
			throws NamingException, SQLException {
		OrdineBC oBC = new OrdineBC();
		oBC.deleteOrdine(id);
	}
	
	@PUT
	@Path("/confermaordine")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public void confermaOrdine(Ordine ordine) 
			throws NamingException, SQLException {
		OrdineBC oBC = new OrdineBC();
		oBC.confermaOrdine(ordine);
	}
}
