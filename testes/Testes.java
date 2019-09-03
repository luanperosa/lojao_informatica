package br.com.TIO_lojao_informatica.testes;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.catalina.startup.Catalina;

import br.com.TIO_lojao_informatica.DAO.CadastroDAO;
import br.com.TIO_lojao_informatica.entidades.Cliente;
import br.com.TIO_lojao_informatica.entidades.Produtos;
import br.com.TIO_lojao_informatica.entidades.Venda;
import br.com.TIO_lojao_informatica.entidades.VwFatura;
import br.com.TIO_lojao_informatica.entidades.VwItens;



public class Testes {
	private static final String VwItens = null;

	public static void main (String[] args){
		
		//testCadastrando();
		//testCadastrar();
		//testVenda();
		//testBuscarTodos();
		//testBuscarPorId();
		//testAutenticar();
		//testBuscarPorVwFatura();
		//testItensBuscarId();
		testBuscarMaior();
		
	}
	private static void testAutenticar(){
		Cliente cliente = new Cliente();
		cliente.setEmail("luan@bol.com.br");
		cliente.setSenha("senha");
		
		CadastroDAO cadastroDAO = new CadastroDAO();
		cadastroDAO.autenticar(cliente);
		
		System.out.println("foi");
		
	}
	
	private static void testCadastrando(){
		Cliente cliente = new Cliente();
		cliente.setNomecli("Luan");
		cliente.setCodigosex(1);
		cliente.setCpf("12345");
		cliente.setTelmovel(12345678);
		cliente.setTelresidencial(129372900);
		cliente.setTelcomercial(876968);
		cliente.setCodigoend(1);
		cliente.setCodigotipoend(3);
		cliente.setCodigologadouro(1);
		cliente.setEndereco("waldemar tietz");
		cliente.setNumero(23);
		cliente.setComplemento("perto do mercado");
		cliente.setBairro("artur alvim");
		cliente.setCidade("sao paulo");
		cliente.setCodigouf(25);
		cliente.setCep("03589000");
		cliente.setEmail("luan@hotmail.com");
		cliente.setSenha("luan123");
		java.util.Date dt = new java.util.Date();
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");  
		try {
			java.util.Date d = df.format();
			
			cliente.setDatacad(new Date(d.getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		/*
		try 
			java.util.Date d = df.parse("12/12/2012");
			cliente.setDatanasc((Date) d);
		} catch (ParseException e) {
			e.printStackTrace();
		} */
		
		
		
		
		CadastroDAO cadastrandoDAO = new CadastroDAO();
		cadastrandoDAO.cadastrando(cliente);
		
		
	}
	
	private static void testCadastrar() {
		Cliente cliente = new Cliente();
		cliente.setNome("martielo sei la ");
		cliente.setCpf("sfds");
		cliente.setEndereco("rua sdfs");
		cliente.setTelefone("777");
		cliente.setEmail("rterte@hotmail.com");
		cliente.setSenha("serifghd");
		
		
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.cadastrar(cliente);
	}
	
	private static void testVenda() {
		Venda venda = new Venda();
		venda.setNomecliente("fjdsaljfd");
		venda.setNomeproduto("sfds");
		venda.setQuantidade(3);
		venda.setPrecounitario(34);
		venda.setPrecototal(34);
		
		VendaDAO vendaDAO = new VendaDAO();
		vendaDAO.vendendo(venda);
		
	}
	
	private static void testBuscarTodos() {
		
		VendaDAO venDAO = new VendaDAO();
		List<Produtos> resultado = venDAO.buscarProdutos();
		
		for (Produtos u: resultado){
			System.out.println(u.getNome()+" " +u.getCaracteristicas()+" " +u.getModelo()+" "+u.getFabricante() +" "+u.getCategoria()+" "+u.getPreco() +" ");
		
//		UsuarioDAO usuDAO = new UsuarioDAO();
//		List<Usuario> resultlista = (List<Usuario>) usuDAO.buscarTodos();
//		for (Usuario u: resultlista){
//			System.out.println(+u.getId()+" " +u.getNome()+" " +u.getLogin()+" "+u.getSenha()+" ");
		}
	
	}
	
	public static void testBuscarPorId(){
		CadastroDAO cadastroDAO = new CadastroDAO();

		Produtos produtos = cadastroDAO.buscarPorId(0);
		
		if(produtos!=null){
			System.out.println("nome: "+produtos.getNome());
			System.out.println("nome: "+produtos.getFabricante());
		}
	}
	
	public static void testBuscarPorVwFatura(){
		CadastroDAO cadastroDAO = new CadastroDAO();

		VwFatura fat = cadastroDAO.buscarPorFatura(1);
		
		if(fat!=null){
			System.out.println("nome: "+fat.getNome_cl());
		}
	}
	
	public static void testItensBuscarId(){
		CadastroDAO cadastroDAO = new CadastroDAO();
		
		List<VwItens> vwitens = cadastroDAO.buscarItensPorId(5);
		if(vwitens!=null){
			System.out.println("sucesso agora");
		}
	}
	
	public static void testBuscarMaior(){
		CadastroDAO cadastroDAO = new CadastroDAO();
		 Integer resultado = cadastroDAO.buscarCodMax();
		   
			 System.out.println(resultado);
		 
	}
}