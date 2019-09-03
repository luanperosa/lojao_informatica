package br.com.TIO_lojao_informatica.entidades;

import java.util.Date;

public class Fatura {
	public int numero;
	public Date data;
	public String nomecliente;
	public String parcela;
	public double valortotal;
	public int codigovenda;
	public Date datavencimento;
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getNomecliente() {
		return nomecliente;
	}
	public void setNomecliente(String nomecliente) {
		this.nomecliente = nomecliente;
	}
	public String getParcela() {
		return parcela;
	}
	public void setParcela(String parcela) {
		this.parcela = parcela;
	}
	public double getValortotal() {
		return valortotal;
	}
	public void setValortotal(double valortotal) {
		this.valortotal = valortotal;
	}
	public int getCodigovenda() {
		return codigovenda;
	}
	public void setCodigovenda(int codigovenda) {
		this.codigovenda = codigovenda;
	}
	public Date getDatavencimento() {
		return datavencimento;
	}
	public void setDatavencimento(Date datavencimento) {
		this.datavencimento = datavencimento;
	}
	
		
}
