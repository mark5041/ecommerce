package com.betacom.businesscomponent.model;

import java.util.Date;

public class Ordine {
	private long idOrdine;
	private Date data;
	private String indirizzo;
	private double totale;
	private String status;
	private long idCliente;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getIdOrdine() {
		return idOrdine;
	}
	
	public void setIdOrdine(long idOrdine) {
		this.idOrdine = idOrdine;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public String getIndirizzo() {
		return indirizzo;
	}
	
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	public double getTotale() {
		return totale;
	}
	
	public void setTotale(double totale) {
		this.totale = totale;
	}
	
	public long getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	@Override
	public String toString() {
		return "Ordine [idOrdine=" + idOrdine + ", data=" + data + ", indirizzo=" + indirizzo + ", totale=" + totale
				+ ", status=" + status + ", idCliente=" + idCliente + "]";
	}
}