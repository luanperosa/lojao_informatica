package br.com.TIO_lojao_informatica.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.TIO_lojao_informatica.conexao.Conexao;
import br.com.TIO_lojao_informatica.entidades.Produtos;
import br.com.TIO_lojao_informatica.entidades.Venda;

public class VendaDAO {
	public void vendendo(Venda venda){
		Connection con = new Conexao().getConnection();
		
		String sql = "INSERT INTO venda (codigo, codigocliente, nomecliente, nomeproduto, quantidade, precounitario, precototal) values (?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement preparador =  con.prepareStatement(sql);
			preparador.setInt(1, venda.getCodigo());
			preparador.setInt(2, venda.getCodigocliente());
			preparador.setString(3, venda.getNomecliente());
			preparador.setString(4, venda.getNomeproduto());
			preparador.setInt(5, venda.getQuantidade());
			preparador.setDouble(6, venda.getPrecounitario());
			preparador.setDouble(7, venda.getPrecototal());
			
			preparador.execute();
			preparador.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		public List<Produtos> buscarProdutos(){
			Connection con = new Conexao().getConnection();	
			
			String sql = "SELECT * FROM produtos";
			
			List<Produtos> produtos = new ArrayList<Produtos>();
		
			try {	

				PreparedStatement preparador = con.prepareStatement(sql);

				ResultSet resultado = preparador.executeQuery();


				while (resultado.next()){
					
					Produtos prod= new Produtos();
					
					prod.setNome(resultado.getString("nome"));
					prod.setCategoria(resultado.getString("categoria"));
					prod.setModelo(resultado.getString("modelo"));
					prod.setFabricante(resultado.getString("fabricante"));
					prod.setCaracteristicas(resultado.getString("caracteristicas"));
					prod.setPreco(resultado.getDouble("preco"));
					
					
					produtos.add(prod);
				}
				
				preparador.close();
			
				System.out.println("Consultado com sucesso");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return produtos;
		
	
	}
		public static Produtos buscarPorCodigo(Integer codigo){
			Connection con = new Conexao().getConnection();		
			
			String sql = "SELECT * FROM produtos WHERE codigo=?";
			
			Produtos produto = null;
			try {
				java.sql.PreparedStatement preparador = con.prepareStatement(sql);
				
				preparador.setInt(1, codigo);
				
				ResultSet resultado = preparador.executeQuery();
				
				if(resultado.next()){
					produto = new Produtos();
					
					produto.setNome(resultado.getString("nome"));
					produto.setCategoria(resultado.getString("categoria"));
					produto.setModelo(resultado.getString("modelo"));
					produto.setFabricante(resultado.getString("fabricante"));
					produto.setCaracteristicas(resultado.getString("caracteristicas"));
					produto.setPreco(resultado.getDouble("preco"));
				
				System.out.println("Consultado com sucesso");
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return produto;
			
		}

}