package br.com.TIO_lojao_informatica.entidades;

import java.util.Calendar;


// no cadastro do cliente vou inserir tres tabelas de uma vez
// tabela cliente, endereço e telefone atraves de 3 procedures diferentes. 

public class Cliente {
	private Integer codcli;//nao vou inserir 
	private String nome;//tb_cliente.nome_cli%type
	private String cpf;//000000000 00 tb_cliente.email%type
	private String email; // tb_cliente.senha%type
	private String senha;// tb_cliente.data_nasc%type
	private Calendar data_n;// vou inserir // tentar calendar
	private Integer sex; //1-feminino 2-masculino
	public Integer getCodcli() {
		return codcli;
	}
	public void setCodcli(Integer codcli) {
		this.codcli = codcli;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Calendar getData_n() {
		return data_n;
	}
	public void setData_n(Calendar data_n) {
		this.data_n = data_n;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	
	
}	