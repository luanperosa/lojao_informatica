package br.com.TIO_lojao_informatica.entidades;

import java.util.Date;

public class VwItens {
	private Integer cod_venda;
	private String nome_prod;
	private String categ_prod;
	private String modelo_prod;
	private String fabric_prod;
	private Integer quant_itens;
	private double valor_prod;
	private Date data_venda;
	
	public Integer getCod_venda() {
		return cod_venda;
	}
	public void setCod_venda(Integer cod_venda) {
		this.cod_venda = cod_venda;
	}
	public String getNome_prod() {
		return nome_prod;
	}
	public void setNome_prod(String nome_prod) {
		this.nome_prod = nome_prod;
	}
	public String getCateg_prod() {
		return categ_prod;
	}
	public void setCateg_prod(String categ_prod) {
		this.categ_prod = categ_prod;
	}
	public String getModelo_prod() {
		return modelo_prod;
	}
	public void setModelo_prod(String modelo_prod) {
		this.modelo_prod = modelo_prod;
	}
	public String getFabric_prod() {
		return fabric_prod;
	}
	public void setFabric_prod(String fabric_prod) {
		this.fabric_prod = fabric_prod;
	}
	public Integer getQuant_itens() {
		return quant_itens;
	}
	public void setQuant_itens(Integer quant_itens) {
		this.quant_itens = quant_itens;
	}
	public double getValor_prod() {
		return valor_prod;
	}
	public void setValor_prod(double valor_prod) {
		this.valor_prod = valor_prod;
	}
	public Date getData_venda() {
		return data_venda;
	}
	public void setData_venda(Date data_venda) {
		this.data_venda = data_venda;
	}
	
	
}
