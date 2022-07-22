package com.betacom.businesscomponent.model;

public class Prodotto {
	private long id;
	private String marca;
	private String modello;
	private double prezzo;
	private int quantita;
	private String img;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "Prodotto [id=" + id + ", marca=" + marca + ", modello=" + modello + ", prezzo=" + prezzo + ", quantita="
				+ quantita + ", img=" + img + "]";
	}
	
	
}
