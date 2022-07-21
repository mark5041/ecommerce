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

import com.betacom.businesscomponent.ProdottoBC;
import com.betacom.businesscomponent.model.Prodotto;

@Path("/prodottoservice")
public class ProdottoService {
	
	@GET
	@Path("/prodotti")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Prodotto> getProdotti() throws NamingException, SQLException {
		ProdottoBC pBC = new ProdottoBC();
		return pBC.getProdotti();
	}
	
	@GET
	@Path("/prodotti/{marca}")
	@Produces(MediaType.APPLICATION_JSON)
	public Prodotto getProdotti(@PathParam("marca") String marca) throws NamingException, SQLException {
		ProdottoBC pBC = new ProdottoBC();
		return pBC.findByMarca(marca);
	}
	
	@GET
	@Path("/prodotto/{modello}")
	@Produces(MediaType.APPLICATION_JSON)
	public Prodotto getProdotto(@PathParam("modello") String modello) throws NamingException, SQLException {
		ProdottoBC pBC = new ProdottoBC();
		return pBC.findByMarca(modello);
	}
	
	@POST
	@Path("/createprodotto")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public Prodotto createProdotto(Prodotto prodotto) 
			throws NamingException, SQLException, ParseException {
		ProdottoBC pBC = new ProdottoBC();
		pBC.createProdotto(prodotto);
		return prodotto;
	}
	
	@PUT
	@Path("/updateprodotto")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public Prodotto updateProdotto(Prodotto prodotto) 
			throws NamingException, SQLException, ParseException {
		ProdottoBC pBC = new ProdottoBC();
		pBC.updateProdotto(prodotto);
		return prodotto;
	}
	
	@DELETE
	@Path("/deleteprodotto/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public void deleteProdotto(@PathParam("id") long id) 
			throws NamingException, SQLException {
		ProdottoBC pBC = new ProdottoBC();
		pBC.deleteProdotto(id);
	}
}
