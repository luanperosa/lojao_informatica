package br.com.TIO_lojao_informatica.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.TIO_lojao_informatica.conexao.Conexao;
import br.com.TIO_lojao_informatica.entidades.Cliente;

public class ClienteDAO {
	public void cadastrar (Cliente cliente){
		Connection con = new Conexao().getConnection();
		
		String sql = "INSERT INTO cliente (nome, cpf, endereco, telefone, email, senha) values (?,?,?,?,?,?)";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, cliente.getNome());
			preparador.setString(2, cliente.getCpf());
			preparador.setString(3, cliente.getEndereco());
			preparador.setString(4, cliente.getTelefone());
			preparador.setString(5, cliente.getEmail());
			preparador.setString(6, cliente.getSenha());
			
			preparador.execute();
			preparador.close();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
}
