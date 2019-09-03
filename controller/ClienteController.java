package br.com.TIO_lojao_informatica.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.TIO_lojao_informatica.DAO.ClienteDAO;
import br.com.TIO_lojao_informatica.entidades.Cliente;


@WebServlet("/clientecontroller.do")
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ClienteController() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recebe dados da tela
		String nome = request.getParameter("txtnome");
		String cpf = request.getParameter("txtcpf");
		String endereco = request.getParameter("txtendereco");
		String telefone = request.getParameter("txttelefone");
		String email = request.getParameter("txtemail");
		String senha = request.getParameter("txtsenha");
		
		//cria objeto Cliente e seta valores vindos da tela
		Cliente cliente = new Cliente();
		
		cliente.setNome(nome);
		cliente.setCpf(cpf);
		cliente.setEndereco(endereco);
		cliente.setTelefone(telefone);
		cliente.setEmail(email);
		cliente.setSenha(senha);
		
		
		// pede usuariodao cadastrar no banco 
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.cadastrar(cliente);
		
		// Saida ao navegador
		ServletContext ctx = getServletContext();
		ctx.setAttribute("abelha", cliente);
		RequestDispatcher dp = ctx.getRequestDispatcher("/fazendoteste.jsp");
		dp.forward(request, response);
	}


}
