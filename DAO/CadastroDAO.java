package br.com.TIO_lojao_informatica.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.TIO_lojao_informatica.conexao.Conexao;
import br.com.TIO_lojao_informatica.entidades.Cliente;
import br.com.TIO_lojao_informatica.entidades.Endereco;
import br.com.TIO_lojao_informatica.entidades.Fatura;
import br.com.TIO_lojao_informatica.entidades.ItensProduto;
import br.com.TIO_lojao_informatica.entidades.Pr_login;
import br.com.TIO_lojao_informatica.entidades.Produtos;
import br.com.TIO_lojao_informatica.entidades.Telefone;
import br.com.TIO_lojao_informatica.entidades.Venda;
import br.com.TIO_lojao_informatica.entidades.VwFatura;
import br.com.TIO_lojao_informatica.entidades.VwItens;

import com.mysql.jdbc.CallableStatement;

public class CadastroDAO {
	public void cadastrando (Cliente cliente){
		Connection con = new Conexao().getConnection();
		//Connection con = new Conexao().getConnectionOracle();
		 
		//String sql = "call pr_cliente (?,?,?,?,?)"
		String sql = "INSERT INTO cliente (nome, cpf, email, senha, data_n, sex) VALUES (?,?,?,?,?,?)";
		
		try {
			//CallableStatement cadastrador = con.prepareCall(sql);
			PreparedStatement cadastrador = (PreparedStatement) con.prepareStatement(sql);
			cadastrador.setString(1, cliente.getNome());
			cadastrador.setString(2, cliente.getCpf());
			cadastrador.setString(3, cliente.getEmail());
			cadastrador.setString(4, cliente.getSenha());
			cadastrador.setDate(5, (Calendar) cliente.getData_n());
			cadastrador.setInt(6, cliente.getSex());
			
			cadastrador.execute();
			cadastrador.close();
			
		} catch (SQLException e) {
			System.out.println("inserir cliente nao foi dao");
			e.printStackTrace();
		}
	}
	public void cadastrandoEnd(Endereco endereco){
		Connection con = new Conexao().getConnection();
		//Connection con = new Conexao().getConnectionOracle();
		
		//String sql = "call pr_endereco (?,?,?,?,?,?,?,?,?)"
		String sql = "INSERT INTO endereco (t_ende, t_logra, ende, num, comple, bair, cid, uf, cep) VALUES (?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement cadastrador = (PreparedStatement) con.prepareStatement(sql);
			cadastrador.setInt(1, endereco.getT_ende());
			cadastrador.setInt(2, endereco.getT_logra());
			cadastrador.setString(3, endereco.getEnde());
			cadastrador.setInt(4, endereco.getNum());
			cadastrador.setString(5, endereco.getComple());
			cadastrador.setString(6, endereco.getBair());
			cadastrador.setString(7, endereco.getCid());
			cadastrador.setInt(8, endereco.getUf());
			cadastrador.setString(9, endereco.getCep());
			
			cadastrador.execute();
			cadastrador.close();
			
			
			
		} catch (SQLException e) {
			System.out.println("nao foi o endereco dao");
			e.printStackTrace();
		}
	}
	
	public void cadastrandoTelefone(Telefone telefone){
		Connection con = new Conexao().getConnection();
		//Connection con = new Conexao().getConnectionOracle();
		
		//String sql = "call pr_telefone (?,?,?)";
		String sql = "INSERT INTO vwtelefone (movel_tf, resid_tf, comer_tf) values (?,?,?)";

		
		try {
			PreparedStatement cadastrador = (PreparedStatement) con.prepareStatement(sql);
			cadastrador.setString(1, telefone.getMovel_tf());
			cadastrador.setString(2, telefone.getResid_tf());
			cadastrador.setString(3, telefone.getComer_tf());
			
			cadastrador.execute();
			cadastrador.close();
			
			
			
		} catch (SQLException e) {
			System.out.println("telefone nao funcionou DAO");
			e.printStackTrace();
		}
	}
	
	public void cadastrandoItensProduto(ItensProduto itensProduto){
		Connection con = new Conexao().getConnection();
		//Connection con = new Conexao().getConnectionOracle();
		
		//String sql = "call pr_endereco (?,?,?)";
		String sql = "INSERT INTO pr_itensprod (codigo_pr, quant_it, valor_pr) values (?,?,?)";

		
		try {
			PreparedStatement cadastrador = (PreparedStatement) con.prepareStatement(sql);
			cadastrador.setInt(1, itensProduto.getCodigo_it());
			cadastrador.setDouble(2, itensProduto.getQuant_it());;
			cadastrador.setDouble(3, itensProduto.getValor_pr());
			
			cadastrador.execute();
			cadastrador.close();
			
			
			
		} catch (SQLException e) {
			System.out.println("vendendo itens nao funcionou DAO");
			e.printStackTrace();
		}
	}
	
	public void inserindoParcelas(Venda venda){
		Connection con = new Conexao().getConnection();
		//Connection con = new Conexao().getConnectionOracle();
		
		//String sql = "call pr_venda (?)";
		String sql = "INSERT INTO pr_venda (q_parcela) values (?)";

		
		try {
			PreparedStatement cadastrador = (PreparedStatement) con.prepareStatement(sql);
			cadastrador.setDouble(1, venda.getQ_parcela());
			
			cadastrador.execute();
			cadastrador.close();
			
			
			
		} catch (SQLException e) {
			System.out.println("vendendo itens nao funcionou DAO");
			e.printStackTrace();
		}
	}
	
	public static Pr_login autenticar(Pr_login pr_login){
		//Connection con = new Conexao().getConnection();
		Connection con = new Conexao().getConnectionOracle();
		String sql = "{call pr_login (?, ?, ?)}";
		//String sql = "SELECT * FROM cliente WHERE email=? and senha=?";

		Pr_login usuarioretorno = null;
		try {
			CallableStatement preparador = con.prepareCall(sql);
			//CallableStatement preparador = con.prepareCall(sql);
			preparador.setString(1, pr_login.getEmail_l());
			preparador.setString(2, pr_login.getSenha_l());
			//preparador.registerOutParameter(3, Types.NUMERIC);
			//preparedor.setPArameterrsult(3, Types.NUMERIC);
			
			//ResultSet resultado = preparador.executeQuery();
			ResultSet resultado = preparador.executeQuery();

			if(resultado.next()){
				usuarioretorno = new Pr_login();
				usuarioretorno.setEmail_l(resultado.getString("email_l"));
				usuarioretorno.setSenha_l(resultado.getString("senha_l"));

				System.out.println("Consultado com sucesso");
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuarioretorno;

	}
	
	public static Cliente autenticarComSelect(Cliente cliente){
		Connection con = new Conexao().getConnection();
		//Connection con = new Conexao().getConnectionOracle();
		
		String sql = "SELECT * FROM cliente WHERE email=? and senha=?";
		
		Cliente usuarioretorno = null;
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
			preparador.setString(1, cliente.getEmail());
			preparador.setString(2, cliente.getSenha());
			
			//ResultSet resultado = preparador.executeQuery();
			ResultSet resultado = preparador.executeQuery();

			if(resultado.next()){
				usuarioretorno = new Cliente();
				usuarioretorno.setCodcli(resultado.getInt("codcli"));
				usuarioretorno.setNome(resultado.getString("nome"));
				usuarioretorno.setCpf(resultado.getString("cpf"));
				usuarioretorno.setEmail(resultado.getString("email"));
				usuarioretorno.setSenha(resultado.getString("senha"));
				usuarioretorno.setSex(resultado.getInt("sex"));

				System.out.println("Consultado com sucesso");
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuarioretorno;

	}
	
		public List<VwItens> buscarItensPorId(Integer cod_venda) {
		Connection con = new Conexao().getConnection();	
		//Connection con = new Conexao().getConnectionOracle();

		String sql = "SELECT * FROM vwitens WHERE cod_venda = ?";
		//String sql = "SELECT * FROM `vw_itens` WHERE cod_venda = ?";
			
			List<VwItens> lista = new ArrayList<VwItens>();
			
		try {	
			
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, cod_venda);
			ResultSet resultado = preparador.executeQuery();


			while (resultado.next()){

				VwItens itensprodutos= new VwItens(); 
				
				itensprodutos.setCod_venda(resultado.getInt("cod_venda"));
				itensprodutos.setNome_prod(resultado.getString("nome_prod"));
				itensprodutos.setCateg_prod(resultado.getString("categ_prod"));
				itensprodutos.setModelo_prod(resultado.getString("modelo_prod"));
				itensprodutos.setFabric_prod(resultado.getString("fabric_prod"));
				itensprodutos.setQuant_itens(resultado.getInt("quant_itens"));
				itensprodutos.setValor_prod(resultado.getDouble("valor_prod"));
				itensprodutos.setData_venda(resultado.getDate("data_venda"));
				
				lista.add(itensprodutos);
			}

				preparador.close();

		} catch (SQLException e) {
			System.out.println("erro na consulta buscar itemproduto por id, metodo buscarItensPorId() cadastroDAO");
			e.printStackTrace();
		}
		return lista;
	}
	
	public Produtos buscarPorId(Integer cod){
		Connection con = new Conexao().getConnection();	
		//Connection con = new Conexao().getConnectionOracle();

		String sql = "SELECT * FROM produtos WHERE cod=?";
		//String sql = "SELECT * FROM vw_produtos WHERE cod=?";

		Produtos produtos = null;
		try {
			PreparedStatement preparador = con.prepareStatement(sql);

			preparador.setInt(1, cod);

			ResultSet resultado = preparador.executeQuery();

			if(resultado.next()){
				produtos = new Produtos();
				produtos.setCod(resultado.getInt("cod"));
				produtos.setNome(resultado.getString("nome"));
				produtos.setCategoria(resultado.getString("categoria"));
				produtos.setModelo(resultado.getString("modelo"));
				produtos.setFabricante(resultado.getString("fabricante"));
				produtos.setCurta(resultado.getString("curta"));
				produtos.setLonga(resultado.getString("longa"));
				produtos.setPreco(resultado.getDouble("preco"));
				produtos.setPreco_desconto(resultado.getDouble("preco_desconto"));
				produtos.setImagem(resultado.getString("imagem"));

				System.out.println("ta indo ");
			}


		} catch (SQLException e) {
			System.out.println("por favor meu");
			e.printStackTrace();
		}
		return produtos;

	}
	
	public Fatura buscarPornumero(Integer numero){
		Connection con = new Conexao().getConnection();	
		//Connection con = new Conexao().getConnectionOracle();

		String sql = "SELECT * FROM fatura WHERE numero=?";
		//String sql = "SELECT * FROM wv_fatura WHERE numero=?";

		Fatura fatura = null;
		try {
			java.sql.PreparedStatement preparador = con.prepareStatement(sql);

			preparador.setInt(1, numero);

			ResultSet resultado = preparador.executeQuery();

			if(resultado.next()){
				fatura = new Fatura();
				fatura.setNumero(resultado.getInt("numero"));
				fatura.setData(resultado.getDate("data"));
				fatura.setNomecliente(resultado.getString("nomecliente"));
				fatura.setParcela(resultado.getString("parcela"));
				fatura.setValortotal(resultado.getDouble("valortotal"));
				fatura.setCodigovenda(resultado.getInt("codigovenda"));
				fatura.setDatavencimento(resultado.getDate("datavencimento"));

				System.out.println("vai pro favor ");
			}


		} catch (SQLException e) {
			System.out.println("puts nao foi");
			e.printStackTrace();
		}
		return fatura;

	}
	
	public VwFatura buscarPorFatura(Integer fatura){
		Connection con = new Conexao().getConnection();		
		//Connection con = new Conexao().getConnectionOracle();

		String sql = "SELECT * FROM vwfatura WHERE fatura=?";
		//String sql = "SELECT * FROM vw_fatura WHERE fatura=?";

		VwFatura faturas = null;
		try {
			PreparedStatement preparador = con.prepareStatement(sql);

			preparador.setInt(1, fatura);

			ResultSet resultado = preparador.executeQuery();

			if(resultado.next()){
				faturas = new VwFatura();
				faturas.setFatura(resultado.getInt("fatura"));
				faturas.setNome_lj(resultado.getString("nome_lj"));
				faturas.setCnpj(resultado.getString("cnpj"));
				faturas.setEmail_lj(resultado.getString("email_lj"));
				faturas.setMovel_lj(resultado.getString("movel_lj"));
				faturas.setResidencia_lj(resultado.getString("residencia_lj"));
				faturas.setComercial_lj(resultado.getString("comercial_lj"));
				faturas.setT_end_lj(resultado.getString("t_end_lj"));
				faturas.setLogra_lj(resultado.getString("logra_lj"));
				faturas.setEnd_lj(resultado.getString("end_lj"));
				faturas.setNum_lj(resultado.getInt("num_lj"));
				faturas.setComple_lj(resultado.getString("comple_lj"));
				faturas.setBair_lj(resultado.getString("bair_lj"));
				faturas.setCid_lj(resultado.getString("cid_lj"));
				faturas.setEst_lj(resultado.getString("est_lj"));
				faturas.setUf_lj(resultado.getString("uf_lj"));
				faturas.setCep_lj(resultado.getString("cep_lj"));
				faturas.setNome_cl(resultado.getString("nome_cl"));
				faturas.setData_n_cl(resultado.getDate("data_n_cl"));
				faturas.setSexo(resultado.getString("sexo"));
				faturas.setCpf(resultado.getString("cpf"));
				faturas.setEmail_cl(resultado.getString("email_cl"));
				faturas.setMovel_cl(resultado.getString("movel_cl"));
				faturas.setResidencial_cl(resultado.getString("residencial_cl"));
				faturas.setComercial_cl(resultado.getString("comercial_cl"));
				faturas.setT_end_cl(resultado.getString("t_end_cl"));
				faturas.setLogra_cl(resultado.getString("logra_cl"));
				faturas.setEnd_cl(resultado.getString("end_cl"));
				faturas.setNum_cl(resultado.getInt("num_cl"));
				faturas.setComple_cl(resultado.getString("comple_cl"));
				faturas.setBair_cl(resultado.getString("bair_cl"));
				faturas.setCid_cl(resultado.getString("cid_cl"));
				faturas.setEst_cl(resultado.getString("est_cl"));
				faturas.setUf_cl(resultado.getString("uf_cl"));
				faturas.setCep_cl(resultado.getString("cep_cl"));
				faturas.setValor_t(resultado.getDouble("valor_t"));
				faturas.setParcela(resultado.getDouble("parcela"));
				faturas.setP_parcela(resultado.getDouble("p_parcela"));
				faturas.setS_parcela(resultado.getDouble("s_parcela"));
				faturas.setData_v(resultado.getDate("data_v"));
				faturas.setData_ent(resultado.getDate("data_ent"));
				faturas.setData_p_parcela(resultado.getDate("data_p_parcela"));
				faturas.setData_s_parcela(resultado.getDate("data_s_parcela"));
			}


		} catch (SQLException e) {
			System.out.println("puts nao foi");
			e.printStackTrace();
		}
		return faturas;

	}
	public VwItens buscarPorItens(Integer cod_venda){
		Connection con = new Conexao().getConnection();	
		//Connection con = new Conexao().getConnectionOracle();

		String sql = "SELECT * FROM vwitens WHERE cod_venda=?";
		//String sql = "SELECT * FROM vw_itens WHERE cod_venda=?";

		VwItens itens = null;
		try {
			PreparedStatement preparador = con.prepareStatement(sql);

			preparador.setInt(1, cod_venda);

			ResultSet resultado = preparador.executeQuery();

			if(resultado.next()){
				itens = new VwItens();
				itens.setCod_venda(resultado.getInt("cod_venda"));
				itens.setNome_prod(resultado.getString("nome_prod"));
				itens.setCateg_prod(resultado.getString("categ_prod"));
				itens.setModelo_prod(resultado.getString("modelo_prod"));
				itens.setFabric_prod(resultado.getString("fabric_prod"));
				itens.setQuant_itens(resultado.getInt("quant_itens"));
				itens.setValor_prod(resultado.getDouble("valor_prod"));
				itens.setData_venda(resultado.getDate("data_venda"));
				
			}


		} catch (SQLException e) {
			System.out.println("erro no metodo buscarPorItens do cadastroDAO");
			e.printStackTrace();
		}
		return itens;

	}
	
	public void excluirVenda(Venda venda){
		Connection con = new Conexao().getConnection();
		
		String sql = "DELETE FROM VENDA where cod_v=?";
		
		try {
		PreparedStatement preparador = con.prepareStatement(sql);
		
		preparador.setInt(1, venda.getCod_v());
		
		preparador.execute();
		preparador.close();
		System.out.println("excluido com sucesso");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	public void excluirItensProduto(ItensProduto itensProduto){
		Connection con = new Conexao().getConnection();
		
		String sql = "DELETE FROM itensproduto where codigo_it=?";
		
		try {
		PreparedStatement preparador = con.prepareStatement(sql);
		
		preparador.setInt(1, itensProduto.getCodigo_it());
		
		preparador.execute();
		preparador.close();
		System.out.println("excluido com sucesso");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
		public void excluirFatura(Fatura fatura){
		Connection con = new Conexao().getConnection();
		
		String sql = "DELETE FROM fatura where numero=?";
		
		try {
		PreparedStatement preparador = con.prepareStatement(sql);
		
		preparador.setInt(1, fatura.getNumero());
		
		preparador.execute();
		preparador.close();
		System.out.println("excluido com sucesso");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
			public Integer buscarCodMaxFatura(){
			Connection con = new Conexao().getConnection();
			
			String sql = "select max(fatura) as fatura from vwfatura";
			
			VwFatura itens = new VwFatura();
			Integer retornofinal = null;
			
			try {
				PreparedStatement preparador = con.prepareStatement(sql);

				ResultSet resultado = preparador.executeQuery();
				resultado.next();
			    retornofinal = resultado.getInt("fatura");
			
					
			} catch (Exception e) {

			}
			
			return retornofinal;
	}
			public Integer buscarCodMax(){
				Connection con = new Conexao().getConnection();
				
				String sql = "select max(cod_venda) as cod_venda from vwItens";
				
				VwItens itens = new VwItens();
				Integer retornofinal = null;
				
				try {
					PreparedStatement preparador = con.prepareStatement(sql);

					ResultSet resultado = preparador.executeQuery();
					resultado.next();
				    retornofinal = resultado.getInt("cod_venda");
				
						
				} catch (Exception e) {

				}
				
				return retornofinal;
		}
			public Integer buscarCodMaxVenda(){
				Connection con = new Conexao().getConnection();
				
				String sql = "select max(cod_v) as cod_venda from venda";
				
				Venda itens = new Venda();
				Integer retornofinal = null;
				
				try {
					PreparedStatement preparador = con.prepareStatement(sql);

					ResultSet resultado = preparador.executeQuery();
					resultado.next();
				    retornofinal = resultado.getInt("cod_v");
				
						
				} catch (Exception e) {

				}
				
				return retornofinal;
		}
}
		

	
	