package br.com.TIO_lojao_informatica.entidades;

import java.util.Date;

public class Venda {
	private Integer cod_v; // nao vou inserir
	private Integer cod_lj; // nao vou inserir
	private Integer cod_cli;// nao vou inserir 
	private double total;// total da venda nao vou inserir 
	private double pparcela; //primeira parcela não vou inserir 
	private double sparcela;// segunda parcela não vou inserir 
	private Date data_v;// data da venda nao vou inserir 
	private Date data_e;//data da entrega nao vou inserir
	private Date data_pp; // data primeira parcela não vou inserir
	private Date data_ps; // data segunda parcela não vou inserir 
	private double q_parcela;// quantidade de parcelas
	
	public Integer getCod_v() {
		return cod_v;
	}
	public void setCod_v(Integer cod_v) {
		this.cod_v = cod_v;
	}
	public Integer getCod_lj() {
		return cod_lj;
	}
	public void setCod_lj(Integer cod_lj) {
		this.cod_lj = cod_lj;
	}
	public Integer getCod_cli() {
		return cod_cli;
	}
	public void setCod_cli(Integer cod_cli) {
		this.cod_cli = cod_cli;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getPparcela() {
		return pparcela;
	}
	public void setPparcela(double pparcela) {
		this.pparcela = pparcela;
	}
	public double getSparcela() {
		return sparcela;
	}
	public void setSparcela(double sparcela) {
		this.sparcela = sparcela;
	}
	public Date getData_v() {
		return data_v;
	}
	public void setData_v(Date data_v) {
		this.data_v = data_v;
	}
	public Date getData_e() {
		return data_e;
	}
	public void setData_e(Date data_e) {
		this.data_e = data_e;
	}
	public Date getData_pp() {
		return data_pp;
	}
	public void setData_pp(Date data_pp) {
		this.data_pp = data_pp;
	}
	public Date getData_ps() {
		return data_ps;
	}
	public void setData_ps(Date data_ps) {
		this.data_ps = data_ps;
	}
	public double getQ_parcela() {
		return q_parcela;
	}
	public void setQ_parcela(double q_parcela) {
		this.q_parcela = q_parcela;
	}
	
	
}
