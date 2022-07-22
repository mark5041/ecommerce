package com.betacom.businesscomponent.model;

public class OrderConfirmed {
	private long cod;
	private String marca;
	private String modello;
	private double prezzo;
	private int quantita;
	
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public long getCod() {
		return cod;
	}
	public void setCod(long cod) {
		this.cod = cod;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	@Override
	public String toString() {
		return "OrderConfirmed [cod=" + cod + ", marca=" + marca + ", modello=" + modello + ", prezzo=" + prezzo
				+ ", quantita=" + quantita + "]";
	}
	
	
}
