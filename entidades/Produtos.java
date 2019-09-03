package br.com.TIO_lojao_informatica.entidades;

import java.util.Date;

public class Produtos {
	private Integer cod;//cod 
	private String nome;//nome
	private String categoria;//categoria
	private String modelo;//modelo
	private String fabricante;//fabricante
	private String curta;// curta
	private String longa;// longa
	private double preco;//preco
	private double preco_desconto;//
	private String imagem;//imagem
	
	public Integer getCod() {
		return cod;
	}
	public void setCod(Integer cod) {
		this.cod = cod;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public String getCurta() {
		return curta;
	}
	public void setCurta(String curta) {
		this.curta = curta;
	}
	public String getLonga() {
		return longa;
	}
	public void setLonga(String longa) {
		this.longa = longa;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public double getPreco_desconto() {
		return preco_desconto;
	}
	public void setPreco_desconto(double preco_desconto) {
		this.preco_desconto = preco_desconto;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
		
}
