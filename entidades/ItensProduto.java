package br.com.TIO_lojao_informatica.entidades;

import java.util.Date;



public class ItensProduto {
	private Integer codigo_it; //nao vou inserir
	private Integer codigo_ven; // nao vou inserir
	private Integer codigo_pr; // codproduto vou inserir
	private double quant_it;// quantidade de itens que o cliente quer comprar
	private double valor_pr;//vou inserir o preço  
	private Date data_ven;//nao vou inserir 
	
	public Integer getCodigo_it() {
		return codigo_it;
	}
	public void setCodigo_it(Integer codigo_it) {
		this.codigo_it = codigo_it;
	}
	public Integer getCodigo_ven() {
		return codigo_ven;
	}
	public void setCodigo_ven(Integer codigo_ven) {
		this.codigo_ven = codigo_ven;
	}
	public Integer getCodigo_pr() {
		return codigo_pr;
	}
	public void setCodigo_pr(Integer codigo_pr) {
		this.codigo_pr = codigo_pr;
	}
	public double getQuant_it() {
		return quant_it;
	}
	public void setQuant_it(double quant_it) {
		this.quant_it = quant_it;
	}
	public double getValor_pr() {
		return valor_pr;
	}
	public void setValor_pr(double valor_pr) {
		this.valor_pr = valor_pr;
	}
	public Date getData_ven() {
		return data_ven;
	}
	public void setData_ven(Date data_ven) {
		this.data_ven = data_ven;
	}
	
	
}
