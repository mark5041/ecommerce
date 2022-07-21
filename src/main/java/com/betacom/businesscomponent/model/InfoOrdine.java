package com.betacom.businesscomponent.model;

public class InfoOrdine {
	private long id_ordine;
	private long id_prodotto;
	private int quantita;
	
	
	public long getId_ordine() {
		return id_ordine;
	}
	
	public void setId_ordine(long id_ordine) {
		this.id_ordine = id_ordine;
	}
	
	public long getId_prodotto() {
		return id_prodotto;
	}
	
	public void setId_prodotto(long id_prodotto) {
		this.id_prodotto = id_prodotto;
	}
	
	public int getQuantita() {
		return quantita;
	}
	
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
}
