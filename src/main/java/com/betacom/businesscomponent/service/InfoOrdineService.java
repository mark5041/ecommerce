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

import com.betacom.businesscomponent.InfoOrdineBC;
import com.betacom.businesscomponent.model.InfoOrdine;
import com.betacom.businesscomponent.model.OrderConfirmed;

@Path("/infordiniservice")
public class InfoOrdineService {
	
	@GET
	@Path("/ordini/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public OrderConfirmed[] getOrderConfirmed(@PathParam("id") long id) throws NamingException, SQLException {
		InfoOrdineBC inf = new InfoOrdineBC();
		return inf.getOrderConfirmed(id);
	}
	
	@GET
	@Path("/carrello/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<OrderConfirmed> getCart(@PathParam("id") long id) throws NamingException, SQLException {
		InfoOrdineBC inf = new InfoOrdineBC();
		return inf.getCart(id);
	}
	
	@POST
	@Path("/aggiungioordine/{prodotti}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public void createInfoOrdine(@PathParam("prodotti") ArrayList<InfoOrdine> io) 
			throws NamingException, SQLException, ParseException {
		InfoOrdineBC inf = new InfoOrdineBC();
		inf.createInfoOrdine(io);
	}
	
	@PUT
	@Path("/updateordine/{prodotti}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public void updateInfoOrdine(@PathParam("prodotti") ArrayList<InfoOrdine> io) 
			throws NamingException, SQLException, ParseException {
		InfoOrdineBC inf = new InfoOrdineBC();
		inf.updateInfoOrdine(io);
	}
	
	@DELETE
	@Path("/deleteordine/{prodotti}")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public void deleteCliente(@PathParam("prodotti") ArrayList<InfoOrdine> io) 
			throws NamingException, SQLException {
		InfoOrdineBC inf = new InfoOrdineBC();
		inf.deleteInfoOrdine(io);
	}
	
}

