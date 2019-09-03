package br.com.TIO_lojao_informatica.entidades;

public class Endereco {
	private Integer v_ende;
	private Integer t_ende; // 1-Residencial 2-comercial 3-correspondencia 4-cobrança 
	private Integer t_logra; // 1-rua 2-avenida 3-travessa
	private String ende; // endereço do cliente
	private Integer num; //numero da casa
	private String comple; //complemento
	private String bair;// bairro
	private String cid; //cidade
	private Integer uf; //
	private String cep;//00000-000
	
	public Integer getV_ende() {
		return v_ende;
	}
	public void setV_ende(Integer v_ende) {
		this.v_ende = v_ende;
	}
	public Integer getT_ende() {
		return t_ende;
	}
	public void setT_ende(Integer t_ende) {
		this.t_ende = t_ende;
	}
	public Integer getT_logra() {
		return t_logra;
	}
	public void setT_logra(Integer t_logra) {
		this.t_logra = t_logra;
	}
	public String getEnde() {
		return ende;
	}
	public void setEnde(String ende) {
		this.ende = ende;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getComple() {
		return comple;
	}
	public void setComple(String comple) {
		this.comple = comple;
	}
	public String getBair() {
		return bair;
	}
	public void setBair(String bair) {
		this.bair = bair;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public Integer getUf() {
		return uf;
	}
	public void setUf(Integer uf) {
		this.uf = uf;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	
}
